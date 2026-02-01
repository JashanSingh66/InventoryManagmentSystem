package com.track.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.track.inventory.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByEmail(String email); // useful for signup check
}
