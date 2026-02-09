package com.track.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.inventory.model.UserStoreModel;

public interface UserStoreRepository extends JpaRepository<UserStoreModel, Long> {
    List<UserStoreModel> findByUserId(Long userId);
}
