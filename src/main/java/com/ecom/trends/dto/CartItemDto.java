package com.ecom.trends.dto;

public record CartItemDto(
        Long productId,
        String name,
        int count,
        double price,
        ProductImage imageUrl
) {}
