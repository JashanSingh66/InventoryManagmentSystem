package com.track.inventory.controller.api;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.inventory.model.ProductModel;
import com.track.inventory.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/products")
public class Product {
    ProductService productService;
    public Product(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    public ProductModel createProduct(@RequestBody ProductModel product){ 
        return productService.createProduct(product);
    }
    @GetMapping("/getProducts/{storeId}")
    public List<ProductModel> getProducts(@PathVariable Long storeId) {
        return productService.getProducts(storeId);
    }

    @GetMapping("/getProductById/{id}")
    public ProductModel getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }    
}
