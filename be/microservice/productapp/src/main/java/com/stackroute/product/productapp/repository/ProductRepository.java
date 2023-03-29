package com.stackroute.product.productapp.repository;

import com.stackroute.product.productapp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
