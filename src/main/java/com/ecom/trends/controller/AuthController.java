package com.ecom.trends.controller;

import com.ecom.trends.config.SessionStore;
import com.ecom.trends.dto.LoginRequest;
import com.ecom.trends.dto.SignupRequest;
import com.ecom.trends.model.User;
import com.ecom.trends.repository.UserRepository;
import com.ecom.trends.service.AuthService;
import com.ecom.trends.service.EmailService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;
    private final SessionStore sessionStore;
    private final EmailService emailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req, HttpSession session){
        if (userRepository.existsByUserName(req.userName)) {
            return ResponseEntity .status(HttpStatus.ACCEPTED)
                    .body("The Username '" + req.userName + "' already exists");
        }

        if (userRepository.existsByEmail(req.email)) {
            return ResponseEntity .status(HttpStatus.ACCEPTED)
                    .body("Email is already associated with another account!");
        }

        session.setAttribute("userData", req);
        int otp = new Random().nextInt(9000) + 1000;

        session.setAttribute("otp", otp);
        session.setMaxInactiveInterval(300); // in seconds

        try {
            emailService.sendOtpAsync(req.email, String.valueOf(otp));


        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    Map.of("error", "OTP service unavailable")
            );
        }


        return ResponseEntity.ok( Map.of(
                "message", "OTP sent. Verify within 5 minutes",
                "sessionId", session.getId()
        ));
    }

    @PostMapping("/signup/verify")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> req, HttpSession session) {

        // Extract OTP sent by user
        String userOtp = req.get("otp");
        Integer serverOtp = (Integer) session.getAttribute("otp");
        SignupRequest signupData = (SignupRequest) session.getAttribute("userData");
        if (serverOtp == null) {
            return ResponseEntity.status(400)
                    .body(Map.of(
                            "error", "Session expired. Please signup again!, null otp")
                    );
        }
        if (signupData == null) {
            return ResponseEntity.status(400)
                    .body(Map.of(
                            "error", " session id wrong"));
        }
        ;
        if (!userOtp.equals(String.valueOf(serverOtp))) {
            return ResponseEntity.status(401)
                    .body(Map.of(
                            "error", "Invalid OTP"
                    ));
        }

        if (signupData.num != null && signupData.num.isEmpty()) signupData.num = null;

        User savedUser = authService.register(signupData);

        session.removeAttribute("otp");
        session.removeAttribute("userData");

        return ResponseEntity.ok(Map.of(
                "uName", savedUser.getUserName(),
                "userId", savedUser.getId()));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req, HttpServletResponse res) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.uName, req.pwd)
            );
        } catch (BadCredentialsException ex) {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(Map.of("message", "Invalid username or password"));
        }


        User user = userRepository.findByUserName(req.uName)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<GrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getUserName(), null, authorities
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        String token = UUID.randomUUID().toString();
        sessionStore.save(token, user.getId());

        Cookie cookie = new Cookie("SESSION_ID", token);
        // cookie.setPath("/");
        // cookie.setHttpOnly(true);
        // cookie.setSecure(true);
        // cookie.setMaxAge(Integer.MAX_VALUE);
        // res.addCookie(cookie);
            res.setHeader(
                "Set-Cookie",
                "SESSION_ID=" + token +
                        "; Path=/" +
                        "; HttpOnly" +
                        "; Secure" +
                        "; SameSite=None"
        );

        return ResponseEntity.ok(Map.of(
                "message", "Login Successful",
                "role", user.getRole().name(),
                "userId", user.getId()
        ));
    }

    @DeleteMapping("/user/account")
    public ResponseEntity<?> deleteAccount(
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(401).body(
                    Map.of("message", "Not authenticated")
            );
        }

        String username = auth.getName();

        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Long userId = user.getId();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("SESSION_ID".equals(c.getName())) {
                    sessionStore.remove(c.getValue());
                }
            }
        }

        userRepository.delete(user);

        Cookie clear = new Cookie("SESSION_ID", null);
        clear.setPath("/");
        clear.setHttpOnly(true);
        clear.setSecure(true); // true in prod
        clear.setMaxAge(0);
        response.addCookie(clear);

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok(
                Map.of("message", "User account deleted successfully")
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("SESSION_ID".equals(c.getName())) {

                    sessionStore.remove(c.getValue());

                    Cookie clear = new Cookie("SESSION_ID", null);
                    clear.setPath("/");
                    clear.setHttpOnly(true);
                    clear.setSecure(true);
                    clear.setMaxAge(0);
                    response.addCookie(clear);
                }
            }
        }

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok(
                Map.of("message", "Logout successful")
        );
    }

}
