package com.track.inventory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.track.inventory.model.StoreModel;
import com.track.inventory.model.UserStoreModel;
import com.track.inventory.repository.StoreRepository;
import com.track.inventory.repository.UserRepository;
import com.track.inventory.repository.UserStoreRepository;

import jakarta.transaction.Transactional;

@Service
public class StoreService {
    StoreRepository storeRepository;
    UserRepository userRepository;
    UserStoreRepository userStoreRepository;
    public StoreService(StoreRepository storeRepository, UserRepository userRepository, UserStoreRepository userStoreRepository){
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
        this.userStoreRepository = userStoreRepository;
    }


    @Transactional
    public StoreModel createStore(StoreModel store, Long userId){
        StoreModel savedStore = storeRepository.save(store);
        UserStoreModel userStore = new UserStoreModel();
        userStore.setUser(
            userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"))
        );
        userStore.setStore(savedStore);
        userStoreRepository.save(userStore);
        return savedStore;
    }

    public StoreModel getStoreById(Long id){
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
    }
    public List<UserStoreModel> getAllStores(Long userId){
        return userStoreRepository.findByUserId(userId);
    }
    
    // public StoreModel joinStore(int storecode,Long userId){
    //     StoreModel savedStore = storeRepository.getByStoreCode(storecode);
    //     UserStoreModel userStore = new UserStoreModel();
    //     userStore.setUser(
    //         userRepository.findById(userId)
    //         .orElseThrow(() -> new RuntimeException("User not found"))
    //     );
    //     userStore.setStore(savedStore);
    //     userStore.setRole(Role.STAFF);
    //     userStore.setStatus(Status.APPROVED);
    //     userStoreRepository.save(userStore);
    //     return savedStore;
    // }


}
