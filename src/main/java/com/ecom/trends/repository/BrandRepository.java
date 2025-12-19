package com.ecom.trends.repository;

import com.ecom.trends.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    static List<String> findTopBrands() {
        return null;
    }
    boolean existsByName(String name);
    boolean existsByNameIgnoreCase(String name);

}