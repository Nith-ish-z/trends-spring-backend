package com.ecom.trends.controller;

import com.ecom.trends.dto.CategoryWiseProductDTO;
import com.ecom.trends.dto.FilterRequestDTO;
import com.ecom.trends.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/f")
public class FilterController {

    private final FilterService filterService;

    @PostMapping
    public ResponseEntity<List<CategoryWiseProductDTO>> filter(@RequestBody FilterRequestDTO req) {

        return ResponseEntity.ok(filterService.filter(req));
    }
}
