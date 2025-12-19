package com.ecom.trends.service;

import com.ecom.trends.exception.BadRequestException;
import com.ecom.trends.model.Brand;
import com.ecom.trends.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Transactional
    public Brand add(Brand brand) {

        if (brand.getName() == null || brand.getName().trim().isEmpty()) {
            throw new BadRequestException("Brand name is required");
        }

        if (brandRepository.existsByNameIgnoreCase(brand.getName())) {
            throw new BadRequestException("Brand already exists with name: " + brand.getName());
        }

        brand.setName(brand.getName().trim());
        return brandRepository.save(brand);
    }


    @Transactional
    public Brand modify(Long id, Brand updated) {
        if (id == null) throw new RuntimeException("Brand id is required");

        Optional<Brand> existingOpt = brandRepository.findById(id);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Brand not found for id: " + id);
        }

        Brand existing = existingOpt.get();

        String newName = updated.getName();
        if (newName != null && !newName.trim().isEmpty() && !newName.equalsIgnoreCase(existing.getName())) {
            if (brandRepository.existsByNameIgnoreCase(newName)) {
                throw new RuntimeException("Another brand exists with name: " + newName);
            }
            existing.setName(newName.trim());
        }

        if (updated.getDescription() != null) {
            existing.setDescription(updated.getDescription());
        }
        if (updated.getImgUrl() != null) {
            existing.setImgUrl(updated.getImgUrl());
        }

        return brandRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        if (id == null) throw new RuntimeException("Brand id is required");
        if (!brandRepository.existsById(id)) {
            throw new RuntimeException("Brand not found for id: " + id);
        }
        brandRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}