package com.ecom.trends.repository.homepage;

import com.ecom.trends.model.homepage.HomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeCategoryRepository
        extends JpaRepository<HomeCategory, Long> {
}