package com.stackroute.product.productapp.service;

import com.stackroute.product.productapp.model.Product;
import com.stackroute.product.productapp.model.User;

import java.util.List;

public interface UserProductService {
    public abstract User addUser(User user);
    public abstract List<User> getAllUsers();
    public abstract User getUserDetails(String emailId);
    public abstract User addProduct(String email,Product product);
}
