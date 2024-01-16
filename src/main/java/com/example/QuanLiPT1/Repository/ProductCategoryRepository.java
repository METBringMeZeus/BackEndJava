package com.example.QuanLiPT1.Repository;

import com.example.QuanLiPT1.Entity.Product_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Product_Category,Integer> {
}
