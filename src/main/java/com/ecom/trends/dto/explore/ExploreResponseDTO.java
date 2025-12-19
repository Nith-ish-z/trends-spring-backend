package com.ecom.trends.dto.explore;

import com.ecom.trends.dto.list.BrandListDTO;
import com.ecom.trends.dto.list.CategoryListDTO;
import java.util.List;

public class ExploreResponseDTO {
    public List<CategoryListDTO> categories;
    public List<BrandListDTO> brands;
}