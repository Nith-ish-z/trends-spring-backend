package com.ecom.trends.controller;

import com.ecom.trends.dto.explore.ExploreResponseDTO;
import com.ecom.trends.dto.list.BrandListDTO;
import com.ecom.trends.dto.list.CategoryListDTO;
import com.ecom.trends.dto.list.SubCatDTO;
import com.ecom.trends.service.BrandService;
import com.ecom.trends.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/categories")
public class CategoryResponseController {

    private final CategoryService categoryService;
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<ExploreResponseDTO> loadCategoryData() {

        List<CategoryListDTO> categoryDTOs =
                categoryService.getAll()
                        .stream()
                        .map(cat -> {
                            CategoryListDTO dto = new CategoryListDTO();
                            dto.cat_id = cat.getId();
                            dto.cat_name = cat.getName();

                            dto.sub_cat =
                                    cat.getSubCategories()
                                            .stream()
                                            .map(sub -> {
                                                SubCatDTO sc = new SubCatDTO();
                                                sc.sub_cat_id = sub.getId();
                                                sc.sub_cat_name = sub.getName();
                                                return sc;
                                            })
                                            .toList();

                            return dto;
                        })
                        .toList();

        List<BrandListDTO> brandDTOs =
                brandService.getAll()
                        .stream()
                        .map(b -> {
                            BrandListDTO dto = new BrandListDTO();
                            dto.id = b.getId();
                            dto.name = b.getName();
                            dto.desc = b.getDescription();
                            dto.url = b.getImgUrl();
                            return dto;
                        })
                        .toList();

        ExploreResponseDTO response = new ExploreResponseDTO();
        response.categories = categoryDTOs;
        response.brands = brandDTOs;

        return ResponseEntity.ok(response);
    }
}