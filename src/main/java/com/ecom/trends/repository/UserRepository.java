package com.ecom.trends.repository;

import com.ecom.trends.model.Role;
import com.ecom.trends.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String uName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    Page<User> findByRole(Role role, Pageable pageable);
}