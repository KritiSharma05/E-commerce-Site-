package com.stackroute.product.productapp.controller;

import com.stackroute.product.productapp.model.Product;
import com.stackroute.product.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/product-app-v1")
public class ProductController {
    @Autowired
    private ProductService productService;
    /*
    GET
    http://localhost:5555/product-app-v1/get-all-products
     */
    @GetMapping("/get-all-products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    /*
 GET
 http://localhost:5555/product-app-v1/get-product-by-id/XXXXX
  */
    @GetMapping("/get-product-by-id/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId){
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }

    /*
 POST
 http://localhost:5555/product-app-v1/admin/add-new-product
  */
    @PostMapping("/admin/add-new-product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){

        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
    }

    /*
 PUT
 http://localhost:5555/product-app-v1/admin/update-product
  */
    @PutMapping("/admin/update-product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
    }

    /*
 DELETE
 http://localhost:5555/product-app-v1/admin/delete-product/XXXXX
  */
    @DeleteMapping("/admin/delete-product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
    }
}
