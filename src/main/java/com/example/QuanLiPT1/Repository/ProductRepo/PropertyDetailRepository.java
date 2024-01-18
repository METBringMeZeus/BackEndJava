package com.example.QuanLiPT1.Repository.ProductRepo;

import com.example.QuanLiPT1.Entity.Product.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailRepository extends JpaRepository <PropertyDetails,Integer>{
}
