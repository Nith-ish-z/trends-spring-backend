package com.ecom.trends.dto.home;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeProductDTO {
    public Long categoryId;
    public Long subCategoryId;
    public Integer count;
}
