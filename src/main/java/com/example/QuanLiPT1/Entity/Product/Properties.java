package com.example.QuanLiPT1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "properties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Properties {
    @Id
    @Column(name = "propertyid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PropertiesID;
    @Column(name = "propertyName")
    private String PropertyName;
    @Column(name = "productid",updatable = false,insertable = false)
    private int ProductID;
    @ManyToOne
    @JoinColumn(name = "productid")
    @JsonBackReference
    Products products;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "properties")
    @JsonManagedReference
    List<PropertyDetails> propertyDetails;

}
