package com.codegym.model.entity;

import javax.persistence.*;

@Entity
public class UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category service;
    private double price;

    public UserService() {
    }

    public UserService(User user, Category service, double price) {
        this.user = user;
        this.service = service;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getService() {
        return service;
    }

    public void setService(Category service) {
        this.service = service;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
