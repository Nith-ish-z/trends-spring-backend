package com.ecom.trends.service;

import com.ecom.trends.dto.home.HomeRequestDTO;
import com.ecom.trends.model.homepage.HomeBrand;
import com.ecom.trends.model.homepage.HomeCarousel;
import com.ecom.trends.model.homepage.HomeCategory;
import com.ecom.trends.model.homepage.HomeProductConfig;
import com.ecom.trends.repository.homepage.HomeBrandRepository;
import com.ecom.trends.repository.homepage.HomeCarouselRepository;
import com.ecom.trends.repository.homepage.HomeCategoryRepository;
import com.ecom.trends.repository.homepage.HomeProductConfigRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomePageService {

    private final ObjectMapper mapper;
    private final HomeCarouselRepository carouselRepo;
    private final HomeBrandRepository brandRepo;
    private final HomeCategoryRepository categoryRepo;
    private final HomeProductConfigRepository productRepo;

    public void saveHome(HomeRequestDTO dto) {

        carouselRepo.deleteAll();
        brandRepo.deleteAll();
        categoryRepo.deleteAll();
        productRepo.deleteAll();

        if (dto.getCarousel() != null) {
            try {
                HomeCarousel carousel = new HomeCarousel();
                carousel.setCarouselJson(mapper.writeValueAsString(dto.getCarousel()));
                carouselRepo.save(carousel);
            } catch (Exception e) {
                throw new RuntimeException("Carousel save failed", e);
            }
        }

        if (dto.getBrands() != null && dto.getBrands().getSelected() != null) {
            for (Long brandId : dto.getBrands().getSelected()) {
                HomeBrand brand = new HomeBrand();
                brand.setBrandId(brandId);
                brandRepo.save(brand);
            }
        }

        if (dto.getCategories() != null) {
            dto.getCategories().forEach(c -> {
                if (c.getCategoryId() == 0) return;

                HomeCategory hc = new HomeCategory();
                hc.setSubCategoryId(c.getCategoryId());
                hc.setTitle(c.getCategoryName());
                hc.setImageUrl(c.getUrl());

                categoryRepo.save(hc);
            });
        }

        if (dto.getProducts() != null) {
            dto.getProducts().forEach(p -> {
                if (p.getCategoryId() == 0) return;

                HomeProductConfig hp = new HomeProductConfig();
                hp.setCategoryId(p.getCategoryId());
                hp.setSubCategoryId(p.getSubCategoryId());
                hp.setCount(p.getCount());

                productRepo.save(hp);
            });
        }
    }
}
