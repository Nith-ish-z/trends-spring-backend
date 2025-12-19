package com.ecom.trends.dto.home;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeCarouselItemDTO {
    private String imgUrl;
    private NavToDTO navTo;

    @Getter @Setter
    public static class NavToDTO {
        private BodyDTO body;
    }

    @Getter @Setter
    public static class BodyDTO {
        private String query;
        private Long categoryId;
    }
}
