package com.ecom.trends.repository;

import com.ecom.trends.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIdAndSubCategoryId(Long catId, Long subCatId);
    List<Product> findByNameContaining(String name);
    Collection<? extends Product> findByCategoryId(Long c);
    Collection<? extends Product> findBySubCategoryId(Long sc);
}