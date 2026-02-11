package com.track.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.track.inventory.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findAllByStoreId(Long storeId);
    
}
