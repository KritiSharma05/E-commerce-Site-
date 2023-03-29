package com.stackroute.product.productapp.service;

import com.stackroute.product.productapp.model.Product;

import java.util.List;

public interface ProductService {
    // getallproducts, getproductbyid, addprodct, deleteproduct, updateproduct
    public abstract List<Product> getAllProducts();
    public abstract Product addProduct(Product product);
    public abstract Product getProductById(String productId);
    public abstract boolean deleteProduct(String productId);
    public abstract Product updateProduct(Product product);
}
