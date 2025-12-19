package com.ecom.trends.service;

import com.ecom.trends.dto.AdminCreateUserDTO;
import com.ecom.trends.dto.AdminUserListDTO;
import com.ecom.trends.model.Role;
import com.ecom.trends.model.User;
import com.ecom.trends.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public User createUser(AdminCreateUserDTO dto) {

        if (userRepo.existsByUserName(dto.username))
            throw new RuntimeException("Username already exists");

        if (userRepo.existsByEmail(dto.email))
            throw new RuntimeException("Email already exists");

        User u = new User();
        u.setFirstName(dto.firstName);
        u.setLastName(dto.lastName);
        u.setUserName(dto.username);
        u.setEmail(dto.email);
        u.setDob(dto.dob);
        u.setNum(dto.mobile);
        u.setPwd(passwordEncoder.encode(dto.password));
        u.setRole(Role.valueOf(dto.role));

        return userRepo.save(u);
    }

    public Page<AdminUserListDTO> listUsers(String role, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<User> users;

        if (role == null || role.equalsIgnoreCase("ALL")) {
            users = userRepo.findAll(pageable);
        } else {
            users = userRepo.findByRole(Role.valueOf(role), pageable);
        }

        return users.map(u -> {
            AdminUserListDTO dto = new AdminUserListDTO();
            dto.id = u.getId();
            dto.userName = u.getUserName();
            dto.fullName = u.getFirstName() + " " + u.getLastName();
            dto.email = u.getEmail();
            dto.num = u.getNum();
            dto.dob = u.getDob();
            dto.role = u.getRole().name();
            return dto;
        });
    }

    public void updateRole(Long userId, String role) {
        User user = userRepo.findById(userId).orElseThrow();
        user.setRole(Role.valueOf(role));
        userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
