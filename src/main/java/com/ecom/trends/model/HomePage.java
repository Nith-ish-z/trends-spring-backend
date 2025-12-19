package com.ecom.trends.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "homepage")
@Getter
@Setter
public class HomePage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String carousel;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String productCard;   // stores JSON array string

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String categories;    // stores JSON array string
}