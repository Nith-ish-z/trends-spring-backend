package com.ecom.trends.model.homepage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "home_categories")
@Getter
@Setter
public class HomeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long subCategoryId;
    private String title;
    private String imageUrl;
}
