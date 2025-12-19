package com.ecom.trends.repository;

import com.ecom.trends.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
    Category findByName(String catName);
}