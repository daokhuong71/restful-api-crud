package com.daoquangkhuong.demo.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String descreption;

    @Column
    private String thumbnail;
    //nhiều product - 1 productcategory
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
}
