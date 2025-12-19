package com.ecom.trends.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name="categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imgUrl;

    @OneToMany(mappedBy="category")
    @JsonManagedReference
    private List<SubCategory> subCategories;

}
