package com.example.QuanLiPT1.Service;

import com.example.QuanLiPT1.Entity.Product.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    ResponseEntity<?> ThemSanPham(Products products);
    public List<Products> GetWomensFeature();
    public List<Products> GetWomensCollection();
    public List<Products> GetMensCollection();
    public List<Products> GetKidsCollection();
    public List<Products> GetAllCollection();


}
