package com.ecom.trends.dto.user;

import java.util.List;

public class CartItemDTO {
    public Long productId;
    public String name;
    public Double price;
    public String category;
    public Long categoryId;
    public String subCategory;
    public Long subCategoryId;
    public List<ProductImage> url;
    public int count;
}
