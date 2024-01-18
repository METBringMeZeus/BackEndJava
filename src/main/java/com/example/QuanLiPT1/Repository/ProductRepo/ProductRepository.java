package com.example.QuanLiPT1.Repository.ProductRepo;

import com.example.QuanLiPT1.Entity.Product.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    @Query(value = "select * from product where product_category_id = 3 and  isfeature = true", nativeQuery = true)
    public List<Products> findWomensFeature();

    @Query(value = "select * from product where product_category_id = 3 and  newcollection = true", nativeQuery = true)
    public List<Products> findWomensCollection();

    @Query(value = "select * from product where product_category_id = 2 and  newcollection = true", nativeQuery = true)
    public List<Products> findMensCollection();
    @Query(value = "select * from product where product_category_id = 1 and  newcollection = true", nativeQuery = true)
    public List<Products> findKidCollection();
    @Query(value = "select * from product where  newcollection = true", nativeQuery = true)
    public List<Products> findAllCollection();

}
