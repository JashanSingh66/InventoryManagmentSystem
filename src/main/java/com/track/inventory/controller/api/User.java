package com.track.inventory.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.track.inventory.model.UserModel;
import com.track.inventory.services.UserService;



@RestController
@RequestMapping("/api/users")
public class User{
    private final UserService userService;

    public User(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserModel user) {
        return ResponseEntity.ok(userService.login(user));
    }
    
    @PutMapping("/update/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }

        // @PostMapping("/login")
    // public String login(@RequestBody UserModel user) {
    //     userService.login(user.getEmail(), user.getPassword());
    //     return "OTP sent to registered email";
    // }
    // @PostMapping("/verify-login-otp/{id}")
    // public String verifyLoginOtp(@PathVariable Long id, @RequestBody UserModel user) {
    //     return userService.verifyLoginOtp(id, user.getOtp());
    // }


    // @GetMapping("/{id}")
    // public UserModel getUserById(@PathVariable Long id){
    //     return userService.getUserById(id);
    // }

    // @PostMapping("/request-otp/{id}")
    // public String requestOtp(@PathVariable Long id) {
    //     UserModel user = userService.getUserById(id);
    //     userService.generateAndSendOtp(user);
    //     return "OTP sent to email";
    // }
}
