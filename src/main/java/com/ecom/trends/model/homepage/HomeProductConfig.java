package com.ecom.trends.model.homepage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "home_products")
@Getter
@Setter
public class HomeProductConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long categoryId;
    private Long subCategoryId;
    private Integer count;
}
