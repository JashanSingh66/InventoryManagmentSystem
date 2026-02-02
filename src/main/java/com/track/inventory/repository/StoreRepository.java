package com.track.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.inventory.model.StoreModel;

public interface StoreRepository extends JpaRepository<StoreModel, Long> {
    
}
