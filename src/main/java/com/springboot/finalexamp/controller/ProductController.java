package com.springboot.finalexamp.controller;


import com.springboot.finalexamp.entity.Product;
import com.springboot.finalexamp.handler.ResponseHandler;
import com.springboot.finalexamp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getAllProduct(){
        List<Product> products =  productService.getAllProduct();
        return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        Optional<Product> product = productService.getProductById(id);
        return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", product);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Product product){
//        return new ResponseEntity(productService.addProduct(product), HttpStatus.CREATED);
        Product newProduct = productService.addProduct(product);
        return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Product> product =  productService.deleteProductById(id);
        return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", product);
    }
}
