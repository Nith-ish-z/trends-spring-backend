package com.ecom.trends.dto;

import java.util.List;

public class FilterRequestDTO {
    public String name;
    public List<Long> categoryId;
    public List<Long> subCategoryId;
    public PriceLimit priceLimit;

    public static class PriceLimit {
        public Double min;
        public Double max;
    }
}
