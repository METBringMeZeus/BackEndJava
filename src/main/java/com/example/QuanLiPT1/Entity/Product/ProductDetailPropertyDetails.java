package com.example.QuanLiPT1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "productdetailpropertydetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "productdetailpropertydetailsid" )
    private int ProductDetailPropertyDetailsID;
    @Column(name = "productdetailid", insertable = false, updatable = false)
    private int ProductDetailID;
    @Column(name = "propertydetailid",insertable = false,updatable = false)
    private int PropertyDetailID;
    @Column(name = "productid", insertable = false, updatable = false)
    private int ProductID;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productdetail")
    ProductDetails productDetails;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productid")
    Products products;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "propertydetailid")
    PropertyDetails propertydetails;

}
