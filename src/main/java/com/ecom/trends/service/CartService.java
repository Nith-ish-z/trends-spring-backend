package com.ecom.trends.service;

import com.ecom.trends.dto.CartResponse;
import com.ecom.trends.model.Cart;
import com.ecom.trends.model.Product;
import com.ecom.trends.model.User;
import com.ecom.trends.repository.CartRepository;
import com.ecom.trends.repository.ProductRepository;
import com.ecom.trends.repository.UserRepository;
import com.ecom.trends.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository repo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    private final WishListRepository wishListRepository;

    @Transactional
    public CartResponse addToCart(Long userId, Long productId) {
        var user = userRepo.findById(userId).orElseThrow();
        var product = productRepo.findById(productId).orElseThrow();

        wishListRepository.deleteByUserIdAndProductId(userId, productId);

        var cart = repo.findByUserIdAndProductId(userId, productId)
                .map(c -> {
                    c.setCount(c.getCount() + 1);
                    return c;
                })
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUser(user);
                    c.setProduct(product);
                    c.setCount(1);
                    return c;
                });

        return toResponse(repo.save(cart));
    }

    private CartResponse toResponse(Cart c) {
        return new CartResponse(
                c.getId(),
                c.getProduct().getId(),
                c.getProduct().getName(),
                c.getProduct().getImages().getFirst(),
                c.getProduct().getPrice(),
                c.getCount()
        );
    }

    @Transactional
    public int removeFromCart(Long userId, Long productId) {
        Cart c = repo.findByUserIdAndProductId(userId, productId)
                .orElseThrow();

        if (c.getCount() > 1) {
            c.setCount(c.getCount() - 1);
            repo.save(c);
            return c.getCount();
        } else {
            repo.delete(c);
            return 0;
        }
    }

    @Transactional
    public void removeAllFromCart(Long userId, Long productId) {
        Cart c = repo.findByUserIdAndProductId(userId, productId)
                .orElseThrow();

        repo.delete(c);;
    }

}