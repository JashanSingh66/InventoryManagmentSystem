package com.track.inventory.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.inventory.model.StoreModel;
import com.track.inventory.model.UserStoreModel;
import com.track.inventory.services.StoreService;


@RestController
@RequestMapping("/api/stores")
public class Store {
    StoreService storeService;
    public Store(StoreService storeService){
        this.storeService = storeService;
    }
    // creation of store by default user will be admin if he create store 
    @PostMapping("/create/{userId}")
    public StoreModel createStore(@RequestBody StoreModel store, @PathVariable Long userId){ 
        return storeService.createStore(store,userId);
    }

    @GetMapping("/allStoreDetails/{userID}")
    public List<UserStoreModel> getAllStoreDetails(@PathVariable Long userID) {
        return storeService.getAllStores(userID);
    }

    // join a store as staff 
    // @PostMapping("/join/{userID}")
    // public StoreModel joinStore(@RequestBody int storeCode,@PathVariable Long userId){
    //     return storeService.joinStore(storeCode,userId);
    // }

    
    // this is for specific store details
    // @GetMapping("/storeDetails/{id}")
    // public StoreModel getStoreDetails(@PathVariable Long id) {
    //     return storeService.getStoreById(id);
    // }

    // to fetch all storedetails of a specific user 
  
}

