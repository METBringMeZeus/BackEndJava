package com.example.QuanLiPT1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "productdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetails {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private int ProductDetailID;
    @Column(name = "productdetailname")
    private String ProductDetailName;
    @Column(name = "quantity")
    private int Quantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetails")
    @JsonManagedReference
    List<ProductDetailPropertyDetails> productDetailPropertyDetails;

}
