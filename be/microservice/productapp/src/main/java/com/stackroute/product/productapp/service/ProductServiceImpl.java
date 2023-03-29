package com.stackroute.product.productapp.service;

import com.stackroute.product.productapp.model.Product;
import com.stackroute.product.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Product addProduct(Product product) {
        return productRepository.insert(product);
    }
    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }
    @Override
    public boolean deleteProduct(String productId) {
        productRepository.deleteById(productId);
        return true;
    }
    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
