package com.ecom.trends.service;

import com.ecom.trends.exception.BadRequestException;
import com.ecom.trends.model.Category;
import com.ecom.trends.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repo;
    public CategoryService(CategoryRepository repo) { this.repo = repo; }

    @Transactional
    public Category add(Category c) {

        if (c.getName() == null || c.getName().trim().isEmpty()) {
            throw new BadRequestException("Category name is required");
        }

        // duplicate check
        if (repo.existsByName(c.getName())) {
            throw new BadRequestException("Category already exists: " + c.getName());
        }

        c.setName(c.getName().trim());
        return repo.save(c);
    }

    public void delete(Long id) { repo.deleteById(id); }
    public List<Category> getAll() { return repo.findAll(); }
}