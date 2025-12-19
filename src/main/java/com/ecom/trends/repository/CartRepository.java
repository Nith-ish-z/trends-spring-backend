package com.ecom.trends.repository;

import com.ecom.trends.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(Long userId);
    Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);

    @Query("SELECT w.product.id FROM WishList w WHERE w.user.id = :userId")
    List<Long> getProductIdsByUser(Long userId);

    @Query("""
        SELECT c.product.id, COUNT(c.product.id)
        FROM Cart c
        GROUP BY c.product.id
        ORDER BY COUNT(c.product.id) DESC
        LIMIT :limit
    """)
    List<Object[]> findTopSellingProducts(int limit);

    void deleteByUserId(Long userId);

}