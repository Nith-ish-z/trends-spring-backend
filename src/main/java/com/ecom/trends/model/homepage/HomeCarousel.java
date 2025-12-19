package com.ecom.trends.model.homepage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "home_carousel")
@Getter
@Setter
public class HomeCarousel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String carouselJson; // stores nested list JSON
}
