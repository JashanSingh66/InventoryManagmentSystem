package com.track.inventory.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.track.inventory.model.UserModel;
import com.track.inventory.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
 

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        return userRepository.save(user);
    }
    public HashMap<String,Object> login(UserModel user){
        UserModel existedUser=userRepository.findByEmail(user.getEmail()).orElseThrow(()->new RuntimeException("Invalid Credentials"));
        HashMap<String,Object> response=new HashMap<>();
        response.put("email",existedUser.getEmail());
        return response;
    }
    
    public UserModel updateUser(Long id, UserModel user) {
        UserModel existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword()); 
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

        // public void login(String email, String password) {
    //     UserModel user = userRepository.findByEmail(email)
    //         .orElseThrow(() -> new RuntimeException("Invalid email or password"));

    //     if (!passwordEncoder.matches(password, user.getPassword())) {
    //         throw new RuntimeException("Invalid email or password");
    //     }

    //     generateAndSendOtp(user); 
    // }

    // public String verifyLoginOtp(Long userId, String otp) {
    //     UserModel user = userRepository.findById(userId)
    //             .orElseThrow(() -> new RuntimeException("User not found"));

    //     if (!otp.equals(user.getOtp())) {
    //         throw new RuntimeException("Invalid OTP");
    //     }
    //     user.setOtp(null);
    //     userRepository.save(user);
    //     return "Login successful";
    // }

    // public UserModel getUserById(Long id){
    //     return userRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("User not found"));
    // }

    // @Async
    // public void generateAndSendOtp(UserModel user){
    //     String otp=OtpUtil.generateOtp();
    //     user.setOtp(otp);
    //     userRepository.save(user);
    //     EmailService.sendOTPEmail(user.getEmail(),otp);
    // }

}
