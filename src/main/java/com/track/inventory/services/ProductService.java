package com.track.inventory.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.track.inventory.repository.ProductRepository;
import com.track.inventory.model.ProductModel;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public ProductModel createProduct(ProductModel prod){
        productRepository.save(prod);
        return prod;
    }
    public List<ProductModel> getProducts(Long storeId){
        return productRepository.findAllByStoreId(storeId);
    }
    public ProductModel getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product with id "+id+" has been deleted successfully";
    }
}
