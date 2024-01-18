package com.example.QuanLiPT1.Repository.ProductRepo;

import com.example.QuanLiPT1.Entity.Product.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Integer> {
}
