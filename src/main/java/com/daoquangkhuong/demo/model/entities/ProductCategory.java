package com.daoquangkhuong.demo.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    //1 productcategory quản lý 1 list product
    @OneToMany(mappedBy = "productCategory")
    private List<Product> products = new ArrayList<>();

}
