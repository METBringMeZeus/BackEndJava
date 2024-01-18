package com.example.QuanLiPT1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "productcategory")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product_Category {
    @Id
    @Column(name = "product_category_id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int ProductCategoryID;
    @Column(name = "category_name")
    private String CategoryName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "productCategory")
    @JsonManagedReference
    List<Products> products;
}
