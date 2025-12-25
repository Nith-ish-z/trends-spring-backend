package com.ecom.trends.service;

import com.ecom.trends.dto.CategoryWiseProductDTO;
import com.ecom.trends.dto.FilterProductDTO;
import com.ecom.trends.dto.FilterRequestDTO;
import com.ecom.trends.model.Product;
import com.ecom.trends.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import com.ecom.trends.model.ProductImage;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final ProductRepository productRepository;

    public List<CategoryWiseProductDTO> filter(FilterRequestDTO req) {

        List<Product> products = productRepository.findAll();

        if (req.name != null && !req.name.trim().isEmpty()) {
            String[] words = req.name.toLowerCase().split("\\s+");

            products = products.stream()
                    .filter(p -> {
                        String pname = p.getName().toLowerCase();
                        return Arrays.stream(words).anyMatch(pname::contains);
                    })
                    .toList();
        }

        if (req.categoryId != null && !req.categoryId.isEmpty()) {
            products = products.stream()
                    .filter(p ->
                            p.getCategory() != null &&
                                    req.categoryId.contains(p.getCategory().getId())
                    )
                    .toList();
        }

        if (req.subCategoryId != null && !req.subCategoryId.isEmpty()) {
            products = products.stream()
                    .filter(p ->
                            p.getSubCategory() != null &&
                                    req.subCategoryId.contains(p.getSubCategory().getId())
                    )
                    .toList();
        }

        if (req.priceLimit != null) {
            Double min = req.priceLimit.min;
            Double max = req.priceLimit.max;

            products = products.stream()
                    .filter(p ->
                            (min == null || p.getPrice() >= min) &&
                                    (max == null || p.getPrice() <= max)
                    )
                    .toList();
        }

        Map<Long, List<Product>> grouped =
                products.stream()
                        .filter(p -> p.getCategory() != null)
                        .collect(Collectors.groupingBy(
                                p -> p.getCategory().getId(),
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        List<CategoryWiseProductDTO> response = new ArrayList<>();

        for (List<Product> categoryProducts : grouped.values()) {

            Product first = categoryProducts.getFirst();

            CategoryWiseProductDTO catDTO = new CategoryWiseProductDTO();
//            catDTO.id = first.getCategory().getId();
            catDTO.category = first.getCategory().getName();

            catDTO.products = categoryProducts.stream()
                    .map(this::mapToDTO)
                    .toList();

            response.add(catDTO);
        }

        return response;
    }

    private FilterProductDTO mapToDTO(Product p) {

        FilterProductDTO dto = new FilterProductDTO();

        dto.productId = p.getId();
        dto.name = p.getName();
        dto.desc = p.getDescription();
        dto.price = p.getPrice();
        dto.stock = p.getStock();
        dto.images = p.getImages()
            .stream()
            .map(ProductImage::getImageUrl)
            .toList();
        dto.ytRef = p.getYtRef();

        if (p.getBrand() != null) {
            dto.brandId = p.getBrand().getId();
            dto.brand = p.getBrand().getName();
        }

        if (p.getCategory() != null) {
            dto.categoryId = p.getCategory().getId();
            dto.category = p.getCategory().getName();
        }

        if (p.getSubCategory() != null) {
            dto.subCategoryId = p.getSubCategory().getId();
            dto.subCategoryName = p.getSubCategory().getName();
        }

        // Thumbnail for cards
        dto.images = p.getImages()
            .stream()
            .map(ProductImage::getImageUrl)
            .toList();

        return dto;
    }

}
