package com.stackroute.product.productapp.service;

import com.stackroute.product.productapp.model.Product;
import com.stackroute.product.productapp.model.User;
import com.stackroute.product.productapp.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductServiceImpl implements UserProductService {

    @Autowired
    private UserProductRepository userProductRepository;

    @Override
    public User addUser(User user) {
        return userProductRepository.insert(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userProductRepository.findAll();
    }

    @Override
    public User getUserDetails(String emailId) {
        return userProductRepository.findById(emailId).get();
    }

    @Override
    public User addProduct(String email, Product product) {
        User user = userProductRepository.findById(email).get();
        user.getProducts().add(product);
        return userProductRepository.save(user);
    }


}
