package com.ecom.trends.repository.homepage;

import com.ecom.trends.model.homepage.HomeCarousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeCarouselRepository extends JpaRepository<HomeCarousel, Long> {
    Optional<HomeCarousel> findFirstByOrderByIdDesc();
}
