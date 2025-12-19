package com.ecom.trends.service;

import com.ecom.trends.dto.ProductDTO;
import com.ecom.trends.model.Product;
import com.ecom.trends.repository.BrandRepository;
import com.ecom.trends.repository.CategoryRepository;
import com.ecom.trends.repository.ProductRepository;
import com.ecom.trends.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Long createProduct(ProductDTO dto) {

        if (dto == null) throw new RuntimeException("Invalid product payload");

        Product p = new Product();
        p.setName(dto.name);
        p.setDescription(dto.desc);
        p.setImages(dto.images);
        p.setYtRef(dto.ytRef);
        p.setStock(dto.stock);

        p.setPrice(dto.price);

        p.setBrand(brandRepository.getReferenceById(dto.brandId));
        p.setCategory(categoryRepository.getReferenceById(dto.categoryId));
        p.setSubCategory(subCategoryRepository.getReferenceById(dto.subCategoryId));

        Product saved = productRepository.save(p);

        return saved.getId();
    }

    public Long updateProduct(Long productId, ProductDTO dto) {

        Product p = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        mapDtoToProduct(dto, p);

        Product updated = productRepository.save(p);
        return updated.getId();
    }

    private void mapDtoToProduct(ProductDTO dto, Product p) {

        p.setName(dto.name);
        p.setDescription(dto.desc);
        p.setImages(dto.images);
        p.setYtRef(dto.ytRef);
        p.setStock(dto.stock);
        p.setPrice(dto.price);

        p.setBrand(brandRepository.getReferenceById(dto.brandId));
        p.setCategory(categoryRepository.getReferenceById(dto.categoryId));
        p.setSubCategory(subCategoryRepository.getReferenceById(dto.subCategoryId));
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}