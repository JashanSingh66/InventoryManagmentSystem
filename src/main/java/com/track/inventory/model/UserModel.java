package com.track.inventory.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class UserModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String otp;

    @OneToMany(mappedBy = "user")
    private List<UserStoreModel> userStores;
    
    //getters
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getOtp() {
        return otp;
    }
    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
}

