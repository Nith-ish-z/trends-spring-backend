package com.ecom.trends.dto;

public record CartResponse(
        Long cartId,
        Long productId,
        String productName,
        ProductImage imageUrl,
        double price,
        int quantity
) {}
