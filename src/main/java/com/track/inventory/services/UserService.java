package com.track.inventory.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.track.inventory.model.UserModel;
import com.track.inventory.repository.UserRepository;
import com.track.inventory.util.OtpUtil;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailService EmailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.EmailService = emailService;
    }

    public UserModel createUser(UserModel user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }



    public UserModel getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    
    public void generateAndSendOtp(UserModel user){
        String otp=OtpUtil.generateOtp();
        user.setOtp(otp);
        userRepository.save(user);
        EmailService.sendOTPEmail(user.getEmail(),otp);
    }

    
    public UserModel updateUser(Long id, UserModel user) {
        UserModel existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getOtp().equals(existingUser.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        if(user.getPassword() != null && !user.getPassword().isEmpty()){
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        existingUser.setOtp(null); 
        return userRepository.save(existingUser);
    }



    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
