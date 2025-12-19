package com.ecom.trends.controller;

import com.ecom.trends.model.Category;
import com.ecom.trends.model.homepage.HomeBrand;
import com.ecom.trends.model.homepage.HomeCarousel;
import com.ecom.trends.model.homepage.HomeProductConfig;
import com.ecom.trends.repository.BrandRepository;
import com.ecom.trends.repository.CategoryRepository;
import com.ecom.trends.repository.ProductRepository;
import com.ecom.trends.repository.SubCategoryRepository;
import com.ecom.trends.repository.homepage.HomeBrandRepository;
import com.ecom.trends.repository.homepage.HomeCarouselRepository;
import com.ecom.trends.repository.homepage.HomeCategoryRepository;
import com.ecom.trends.repository.homepage.HomeProductConfigRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomePageController {

    private final ObjectMapper mapper;
    private final BrandRepository brandRepository;
    private final HomeCarouselRepository carouselRepo;
    private final HomeBrandRepository brandRepo;
    private final HomeCategoryRepository categoryRepo;
    private final HomeProductConfigRepository productRepo;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SubCategoryRepository subCategoryRepository;

    @GetMapping
    public ResponseEntity<?> home() {

        Map<String, Object> res = new HashMap<>();

        HomeCarousel carousel =
                carouselRepo.findFirstByOrderByIdDesc().orElse(null);

        try {
            res.put("carousel",
                    carousel != null
                            ? mapper.readValue(carousel.getCarouselJson(), Object.class)
                            : List.of());
        } catch (Exception e) {
            res.put("carousel", List.of());
        }

        List<Long> selectedBrandIds =
                brandRepo.findAll()
                        .stream()
                        .map(HomeBrand::getBrandId)
                        .toList();

        List<Map<String, Object>> brands = new ArrayList<>();

        brandRepository.findAllById(selectedBrandIds).forEach(b -> {
            Map<String, Object> m = new HashMap<>();
            m.put("id", b.getId());
            m.put("name", b.getName());
            m.put("logo", b.getImgUrl());
            brands.add(m);
        });

        res.put("brands", brands);

        List<Map<String, Object>> categories = new ArrayList<>();

        categoryRepo.findAll().forEach(c -> {

            var subCat = subCategoryRepository
                    .findById(c.getSubCategoryId())
                    .orElse(null);

            Map<String, Object> m = new HashMap<>();
            m.put("categoryId", c.getSubCategoryId());
            m.put("categoryName", c.getTitle());
            m.put("desc", subCat != null ? subCat.getDescription() : null);
            m.put("url", c.getImageUrl());
            categories.add(m);
        });

        res.put("categories", categories);

        List<Map<String, Object>> productSections = new ArrayList<>();

        for (HomeProductConfig cfg : productRepo.findAll()) {

            String categoryName = categoryRepository
                    .findById(cfg.getCategoryId())
                    .map(Category::getName)
                    .orElse("Unknown");

            List<Map<String, Object>> products =
                    productRepository
                            .findByCategoryIdAndSubCategoryId(
                                    cfg.getCategoryId(),
                                    cfg.getSubCategoryId()
                            )
                            .stream()
                            .limit(cfg.getCount())
                            .map(p -> {
                                Map<String, Object> m = new HashMap<>();
                                m.put("id", p.getId());
                                m.put("name", p.getName());
                                m.put("price", p.getPrice());
                                m.put("subcatname", p.getSubCategory().getName());
                                m.put("url",
                                        p.getImages() != null && !p.getImages().isEmpty()
                                                ? p.getImages().getFirst()
                                                : null
                                );
                                return m;
                            })
                            .toList();

            if (!products.isEmpty()) {
                Map<String, Object> section = new HashMap<>();
                section.put("category", categoryName);
                section.put("products", products);
                productSections.add(section);
            }
        }

        res.put("products", productSections);

        return ResponseEntity.ok(res);
    }
}
