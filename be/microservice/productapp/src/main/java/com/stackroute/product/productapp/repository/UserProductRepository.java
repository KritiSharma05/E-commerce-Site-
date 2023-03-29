package com.stackroute.product.productapp.repository;

import com.stackroute.product.productapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProductRepository extends MongoRepository<User, String> {
    // save() / insert()
    // custom

}
