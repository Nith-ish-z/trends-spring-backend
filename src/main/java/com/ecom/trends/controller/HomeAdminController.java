package com.ecom.trends.controller;

import com.ecom.trends.dto.home.HomeRequestDTO;
import com.ecom.trends.service.HomePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/home")
public class HomeAdminController {

    private final HomePageService homePageService;

    @PostMapping
    public ResponseEntity<?> saveHome(@RequestBody HomeRequestDTO dto) {
        homePageService.saveHome(dto);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Homepage updated"
        ));
    }

}
