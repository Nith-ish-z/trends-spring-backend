package com.ecom.trends.repository;

import com.ecom.trends.model.HomePage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePageRepository extends JpaRepository<HomePage, Long> {
}