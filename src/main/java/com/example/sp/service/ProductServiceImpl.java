package com.example.sp.service;


import com.example.sp.model.Product;
import com.example.sp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public Product updateProduct(Product product, Integer id) {
        Product oldProduct = productRepository.findById(id).get();

        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStatus(product.getStatus());

        return productRepository.save(oldProduct);
    }
    @Override
    public String deleteProductById(Integer id) {

        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()) {
            productRepository.deleteById(id);
            return "The Product is deleted successfully";
        }

        return "Something went wrong";
    }
}
