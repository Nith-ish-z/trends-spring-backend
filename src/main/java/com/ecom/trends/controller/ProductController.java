package com.ecom.trends.controller;

import com.ecom.trends.dto.ProductDTO;
import com.ecom.trends.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("admin/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Map<String, Object>> createProduct(@RequestBody ProductDTO dto) {

        Long id = productService.createProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "productId", id,
                "message", "Product created successfully"
        ));
    }

    @PutMapping("/modify")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> modifyProduct(
            @RequestParam Long id,
            @RequestBody ProductDTO dto
    ) {

        Long updatedId = productService.updateProduct(id, dto);

        return ResponseEntity.ok(Map.of(
                "productId", updatedId,
                "message", "Product updated successfully"
        ));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.ok(Map.of(
                "message", "Product deleted successfully"
        ));
    }
}
