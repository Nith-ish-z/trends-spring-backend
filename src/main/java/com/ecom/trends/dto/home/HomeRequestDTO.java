package com.ecom.trends.dto.home;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class HomeRequestDTO {

    private Object carousel;

    private HomeBrandDTO brands;

    private List<HomeCategoryDTO> categories;

    private List<HomeProductDTO> products;
}
