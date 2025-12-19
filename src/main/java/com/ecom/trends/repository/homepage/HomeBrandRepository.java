package com.ecom.trends.repository.homepage;

import com.ecom.trends.model.homepage.HomeBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeBrandRepository
        extends JpaRepository<HomeBrand, Long> {
}