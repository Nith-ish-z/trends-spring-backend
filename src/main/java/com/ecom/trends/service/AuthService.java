package com.ecom.trends.service;

import com.ecom.trends.dto.SignupRequest;
import com.ecom.trends.model.Role;
import com.ecom.trends.model.User;
import com.ecom.trends.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(SignupRequest req) {

        User u = new User();
        u.setFirstName(req.firstName);
        u.setLastName(req.lastName);
        u.setUserName(req.userName);
        u.setPwd(passwordEncoder.encode(req.pwd));
        u.setDob(req.dob);
        u.setEmail(req.email);
        u.setNum(req.num);
        u.setRole(Role.CUSTOMER);

        return userRepository.save(u);
    }


    @Transactional
    public User registerUser(SignupRequest signupData, User user) {
        return userRepository.save(user);
    }
}