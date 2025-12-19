package com.ecom.trends.service;

import com.ecom.trends.model.WishList;
import com.ecom.trends.model.User;
import com.ecom.trends.model.Product;
import com.ecom.trends.repository.WishListRepository;
import com.ecom.trends.repository.UserRepository;
import com.ecom.trends.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WishListService {
    private final WishListRepository repo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public WishListService(WishListRepository repo, UserRepository userRepo, ProductRepository productRepo) {
        this.repo = repo; this.userRepo = userRepo; this.productRepo = productRepo;
    }

    @Transactional
    public WishList add(Long userId, Long productId) {
        User u = userRepo.findById(userId).orElseThrow(
                ()-> new RuntimeException("No User Found")
        );
        Product p = productRepo.findById(productId).orElseThrow(
                ()-> new RuntimeException("Invalid Product")
        );
        var ex = repo.findByUserIdAndProductId(userId, productId);
        if (ex.isPresent()) return ex.get();
        WishList w = new WishList();
        w.setUser(u); w.setProduct(p);
        return repo.save(w);
    }

    @Transactional
    public void remove(Long userId, Long productId) {
        var ex = repo.findByUserIdAndProductId(userId, productId);
        ex.ifPresent(repo::delete);
    }

}