package com.ecom.trends.controller;

import com.ecom.trends.config.SessionStore;
import com.ecom.trends.service.WishListService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/wishlist")
public class WishListController {

    private final WishListService wishListService;
    private final SessionStore sessionStore;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestParam Long productId,
            HttpServletRequest request
    ) {

        Long userId = resolveUserId(request);
        if (userId == null) {
            return ResponseEntity.status(401).body(
                    Map.of("message", "Please login")
            );
        }

        wishListService.add(userId, productId);
        return ResponseEntity.ok(Map.of("message", "Added to wishlist"));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> remove(
            @RequestParam Long productId,
            HttpServletRequest request
    ) {

        Long userId = resolveUserId(request);
        if (userId == null) {
            return ResponseEntity.status(401).body(
                    Map.of("message", "Please login")
            );
        }

        wishListService.remove(userId, productId);
        return ResponseEntity.ok(Map.of("message", "Removed from wishlist"));
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
}
