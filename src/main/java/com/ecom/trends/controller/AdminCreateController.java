package com.ecom.trends.controller;

import com.ecom.trends.dto.BrandDTO;
import com.ecom.trends.dto.CategoryDTO;
import com.ecom.trends.dto.ProductDTO;
import com.ecom.trends.dto.SubCategoryDTO;
import com.ecom.trends.model.Brand;
import com.ecom.trends.model.Category;
import com.ecom.trends.model.SubCategory;
import com.ecom.trends.service.BrandService;
import com.ecom.trends.service.CategoryService;
import com.ecom.trends.service.ProductService;
import com.ecom.trends.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/create")
public class AdminCreateController {

    private final BrandService brandService;
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final ProductService productService;

    @PostMapping("/brand")
    public ResponseEntity<?> addBrand(@RequestBody BrandDTO dto) {

        Brand brand = new Brand();
        brand.setName(dto.getName());
        brand.setDescription(dto.getDesc());
        brand.setImgUrl(dto.getImgUrl());

        Brand saved = brandService.add(brand);

        dto.setId(saved.getId());  // returning id back

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/category")
    public ResponseEntity<?> create(@RequestBody CategoryDTO dto) {

        Category c = new Category();
        c.setName(dto.catName);
        c.setDescription(dto.desc);
        c.setImgUrl(dto.logoUrl);

        return ResponseEntity.ok(categoryService.add(c));
    }

    @PostMapping("/subcategory")
    public ResponseEntity<?> create(@RequestBody SubCategoryDTO dto) {

        SubCategory sc = new SubCategory();
        sc.setName(dto.subCat);
        sc.setDescription(dto.desc);
        sc.setImgUrl(dto.logoUrl);

        return ResponseEntity.ok(subCategoryService.add(sc, dto.catId));
    }

    @PostMapping("/product")
    public ResponseEntity<Map<String, Object>> createProduct(
            @RequestBody ProductDTO dto
    ) {

        Long productId = productService.createProduct(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "status", "success",
                        "productId", productId,
                        "message", "Product created successfully"
                ));
    }
}
