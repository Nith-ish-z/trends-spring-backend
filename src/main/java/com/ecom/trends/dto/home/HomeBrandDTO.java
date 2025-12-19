package com.ecom.trends.dto.home;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class HomeBrandDTO {
    private Integer limit;
    private List<Long> selected;
}