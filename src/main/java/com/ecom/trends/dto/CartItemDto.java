package com.ecom.trends.dto;

import com.ecom.trends.model.ProductImage;

public record CartItemDto(
        Long productId,
        String name,
        int count,
        double price,
        ProductImage imageUrl
) {}
