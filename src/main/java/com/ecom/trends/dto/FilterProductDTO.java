package com.ecom.trends.dto;

import java.util.List;
import com.ecom.trends.model.ProductImage;

public class FilterProductDTO {

    public Long productId;

    public String name;
    public String desc;

    public String brand;

    public Double price;
    public Integer stock;

    public Long brandId;

    public Long categoryId;
    public String category;

    public Long subCategoryId;
    public String subCategoryName;

    public List<ProductImage> images;
    public String ytRef;
}
