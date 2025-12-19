package com.ecom.trends.repository.homepage;

import com.ecom.trends.model.homepage.HomeProductConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeProductConfigRepository
        extends JpaRepository<HomeProductConfig, Long> {
}