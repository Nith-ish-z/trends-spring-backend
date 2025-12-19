package com.ecom.trends.controller;

import com.ecom.trends.dto.AdminCreateUserDTO;
import com.ecom.trends.dto.UserRoleUpdateDTO;
import com.ecom.trends.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@RequestBody AdminCreateUserDTO dto) {

        var user = service.createUser(dto);

        return ResponseEntity.ok(
                Map.of(
                        "message", "User created successfully",
                        "userId", user.getId()
                )
        );
    }

    @GetMapping
    public ResponseEntity<?> listUsers(
            @RequestParam(defaultValue = "ALL") String role,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(service.listUsers(role, page, limit));
    }

    @PutMapping("/role")
    public ResponseEntity<?> updateRole(@RequestBody UserRoleUpdateDTO dto) {
        service.updateRole(dto.userId, dto.role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable Long userId) {
        service.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
