package com.track.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.inventory.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByEmail(String email); 
    Optional<UserModel> findByEmail(String email);
}
