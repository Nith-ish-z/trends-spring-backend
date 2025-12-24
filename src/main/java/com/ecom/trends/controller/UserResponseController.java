package com.ecom.trends.controller;

import com.ecom.trends.config.SessionStore;
import com.ecom.trends.dto.UpdateProfileDTO;
import com.ecom.trends.dto.user.*;
import com.ecom.trends.model.User;
import com.ecom.trends.repository.CartRepository;
import com.ecom.trends.repository.UserRepository;
import com.ecom.trends.repository.WishListRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.ecom.trends.model.ProductImage;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserResponseController {

    private final SessionStore sessionStore;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final WishListRepository wishListRepository;

    @GetMapping
    public ResponseEntity<?> getUser(HttpServletRequest req) {

        String token = extractSessionToken(req);

        if (token == null) {
            return guestResponse();
        }

        Long userId = sessionStore.get(token);

        if (userId == null) {
            return guestResponse();
        }

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return guestResponse();
        }

        UserResponseDTO res = buildUserResponse(user);

        return ResponseEntity.ok(res);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(
            @RequestBody UpdateProfileDTO dto,
            HttpServletRequest req
    ) {
        Long userId = resolveUserId(req);

        if (userId == null) {
            return ResponseEntity.status(401)
                    .body(Map.of("message", "Please login"));
        }

        User user = userRepository.findById(userId).orElseThrow();

        if (dto.fName != null) user.setFirstName(dto.fName);
        if (dto.lName != null) user.setLastName(dto.lName);
        if (dto.mob != null) user.setNum(dto.mob);
        if (dto.url != null) user.setProfileUrl(dto.url);
        if (dto.dob != null) user.setDob(dto.dob);

        userRepository.save(user);

        UserResponseDTO res = buildUserResponse(user);

        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAccount(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Long userId = resolveUserId(request);

        if (userId == null) {
            return ResponseEntity.status(401)
                    .body(Map.of("message", "Please login"));
        }

        cartRepository.deleteByUserId(userId);
        wishListRepository.deleteByUserId(userId);

        userRepository.deleteById(userId);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("SESSION_ID".equals(c.getName())) {
                    sessionStore.remove(c.getValue());

                    Cookie clear = new Cookie("SESSION_ID", null);
                    clear.setPath("/");
                    clear.setMaxAge(0);
                    response.addCookie(clear);
                }
            }
        }

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok(
                Map.of("message", "Account deleted successfully")
        );
    }



    private Long resolveUserId(HttpServletRequest req) {
        if (req.getCookies() == null) return null;

        for (Cookie c : req.getCookies()) {
            if ("SESSION_ID".equals(c.getName())) {
                return sessionStore.get(c.getValue());
            }
        }
        return null;
    }

    private String extractSessionToken(HttpServletRequest req) {
        if (req.getCookies() == null) return null;

        for (Cookie c : req.getCookies()) {
            if ("SESSION_ID".equals(c.getName())) {
                return c.getValue();
            }
        }
        return null;
    }

    private ResponseEntity<Map<String, String>> guestResponse() {
        return ResponseEntity.ok(Map.of(
                "role", "GUEST"
        ));
    }

    private UserResponseDTO buildUserResponse(User user) {

        Long userId = user.getId();

        UserResponseDTO res = new UserResponseDTO();

        res.userId = userId;
        res.username = user.getUserName();
        res.email = user.getEmail();
        res.dob = user.getDob();
        res.mob = user.getNum();
        res.role = user.getRole().name();
        res.profileImg = user.getProfileUrl();

        NameDTO name = new NameDTO();
        name.fname = user.getFirstName();
        name.lname = user.getLastName();
        res.name = name;

        res.cartItem = cartRepository.findByUserId(userId)
                .stream()
                .map(c -> {
                    CartItemDTO dto = new CartItemDTO();
                    dto.productId = c.getProduct().getId();
                    dto.name = c.getProduct().getName();
                    dto.price = c.getProduct().getPrice();
                    dto.category = c.getProduct().getCategory().getName();
                    dto.categoryId = c.getProduct().getCategory().getId();
                    dto.subCategory = c.getProduct().getSubCategory().getName();
                    dto.subCategoryId = c.getProduct().getSubCategory().getId();
                    dto.url = c.getProduct().getImages();
                    dto.count = c.getCount();
                    return dto;
                })
                .toList();

        res.wishItem = wishListRepository.findByUserId(userId)
                .stream()
                .map(w -> {
                    WishItemDTO dto = new WishItemDTO();
                    dto.productId = w.getProduct().getId();
                    dto.name = w.getProduct().getName();
                    dto.price = w.getProduct().getPrice();
                    dto.category = w.getProduct().getCategory().getName();
                    dto.categoryId = w.getProduct().getCategory().getId();
                    dto.subCategory = w.getProduct().getSubCategory().getName();
                    dto.subCategoryId = w.getProduct().getSubCategory().getId();
                    dto.url = w.getProduct().getImages();
                    return dto;
                })
                .toList();

        return res;
    }
}
