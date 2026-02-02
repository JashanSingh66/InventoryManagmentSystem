package com.track.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_store")
public class UserStoreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreModel store;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public StoreModel getStore() {
        return store;
    }
    public void setStore(StoreModel store) {
        this.store = store;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}
