package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.Entity.Product.Products;
import com.example.QuanLiPT1.Repository.ProductRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Transactional
    @Override
    public ResponseEntity<?> ThemSanPham(Products products) {
        Optional<Products> product = productRepository.findById(products.getProductID());
        if(product.isPresent()){
            return new ResponseEntity<>("Da ton tai", HttpStatus.NO_CONTENT);
        }
        else {
            productRepository.save(products);
            return new ResponseEntity<>("Lưu thành công", HttpStatus.OK);
        }
    }
    @Override
    public List<Products> GetWomensFeature() {
        List<Products> products = productRepository.findWomensFeature();
        return products;
    }
    @Override
    public List<Products> GetWomensCollection() {
        List<Products> products = productRepository.findWomensCollection();
        return products;
    }
    @Override
    public List<Products> GetMensCollection() {
        List<Products> products = productRepository.findMensCollection();
        return products;
    }
    @Override
    public List<Products> GetKidsCollection() {
        List<Products> products = productRepository.findKidCollection();
        return products;
    }
    @Override
    public List<Products> GetAllCollection() {
        List<Products> products = productRepository.findAllCollection();
        return products;
    }


}
