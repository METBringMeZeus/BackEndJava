package com.example.QuanLiPT1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "propertydetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyDetails {
    @Id
    @Column(name = "propertydetailid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PropertyDetailID;
    @Column(name = "propertyid",updatable = false,insertable = false)
    private int PropertyID;
    @Column(name = "propertyname")
    private String PropertyName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "propertydetails")
    @JsonManagedReference
    List<ProductDetailPropertyDetails> productDetailPropertyDetails;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "propertyid")
    Properties properties;

}
