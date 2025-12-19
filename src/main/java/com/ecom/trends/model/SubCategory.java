package com.ecom.trends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="subcategories")
@Getter
@Setter
public class SubCategory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonBackReference
    private Category category;
}
