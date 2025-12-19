package com.ecom.trends.service;

import com.ecom.trends.exception.BadRequestException;
import com.ecom.trends.model.SubCategory;
import com.ecom.trends.repository.CategoryRepository;
import com.ecom.trends.repository.SubCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository repo;
    private final CategoryRepository categoryRepo;

    @Transactional
    public SubCategory add(SubCategory s, Long catId) {

        if (catId == null) {
            throw new BadRequestException("Category ID is required");
        }

        var category = categoryRepo.findById(catId)
                .orElseThrow(() -> new BadRequestException("Category not found: " + catId));

        if (s.getName() == null || s.getName().trim().isEmpty()) {
            throw new BadRequestException("Sub-category name is required");
        }

        boolean exists = repo.findByCategoryId(catId).stream()
                .anyMatch(sc -> sc.getName().equalsIgnoreCase(s.getName()));

        if (exists) {
            throw new BadRequestException(
                    "Sub-category already exists under this category: " + s.getName()
            );
        }

        s.setName(s.getName().trim());
        s.setCategory(category);

        return repo.save(s);
    }
}
