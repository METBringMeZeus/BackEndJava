package com.example.QuanLiPT1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @Column(name = "productID")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int ProductID;
    @Column(name = "productname")
    private String ProductName;
    @Column(name = "oldvalue")
    private double OldValue;
    @Column(name = "newvalue")
    private double NewValue;
    @Column(name = "description")
    private String Description;
    @Column(name = "img")
    private String img;
    @Column(name = "product_category_id",insertable = false,updatable = false)
    private int ProductCategoryID;
    @Column(name = "isfeature")
    private boolean isFeature;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "newcollection")
    private boolean NewCollection;
    @ManyToOne()
    @JoinColumn(name = "product_category_id")
    @JsonBackReference
    Product_Category productCategory;
}
