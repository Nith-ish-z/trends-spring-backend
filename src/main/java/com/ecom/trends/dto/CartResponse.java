package com.ecom.trends.dto;

import com.ecom.trends.model.ProductImage;

public record CartResponse(
        Long cartId,
        Long productId,
        String productName,
        ProductImage imageUrl,
        double price,
        int quantity
) {}
