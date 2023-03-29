package com.stackroute.product.productapp.controller;

import com.stackroute.product.productapp.model.Product;
import com.stackroute.product.productapp.model.User;
import com.stackroute.product.productapp.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/product-app-v1")
public class UserProductController {

    @Autowired
    private UserProductService userProductService;

    // http://localhost:5555/product-app-v1/add-user  [POST]
    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody User user){
        user.setProducts(new ArrayList<Product>());
        return new ResponseEntity(userProductService.addUser(user), HttpStatus.OK);
    }

//    // http://localhost:5555/product-app-v1/get-all-users  [GET]
//    @GetMapping("/get-all-users")
//    public ResponseEntity<?> getAllUsers(){
//        return new ResponseEntity<>(userProductService.getAllUsers(),HttpStatus.OK);
//    }

    // http://localhost:5555/product-app-v1/get-user-details  [GET]
    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request){
        String emailid = (String) request.getAttribute("current_user_emailid");
        return new ResponseEntity<>(userProductService.getUserDetails(emailid),HttpStatus.OK);
    }

    // http://localhost:5555/product-app-v1/add-product-to-user  [POST]
    @PostMapping("/add-product-to-user")
    public ResponseEntity<?> addProduct(@RequestBody Product product, HttpServletRequest request){
        String current_email= (String) request.getAttribute("current_user_emailid");
        return new ResponseEntity<>(userProductService.addProduct(current_email,product),HttpStatus.OK);
    }

}







/*


 */