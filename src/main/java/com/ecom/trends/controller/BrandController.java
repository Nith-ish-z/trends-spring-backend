package com.ecom.trends.controller;

import com.ecom.trends.model.Brand;
import com.ecom.trends.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/brand")
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'MEMBER')")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/add")
    public Brand add(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Brand> modify(@PathVariable Long id, @RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.modify(id, brand));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        brandService.delete(id);
        return ResponseEntity.ok("Brand deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Brand>> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }
}