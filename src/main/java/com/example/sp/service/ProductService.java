package com.example.sp.service;

import com.example.sp.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Integer id);
    public String deleteProductById(Integer id);
    public Product updateProduct(Product product,Integer id);




}
