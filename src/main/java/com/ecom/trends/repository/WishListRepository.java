package com.ecom.trends.repository;

import com.ecom.trends.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findByUserId(Long userId);
    Optional<WishList> findByUserIdAndProductId(Long userId, Long productId);
    @Query("select w.product.id from WishList w where w.user.id = :userId")
    List<Long> findProductIdsByUserId(@Param("userId") Long userId);
    void deleteByUserIdAndProductId(Long userId,Long productId);
    void deleteByUserId(Long userId);
}