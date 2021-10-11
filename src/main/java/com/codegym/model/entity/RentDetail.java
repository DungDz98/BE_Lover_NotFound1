package com.codegym.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne

    private Rent rent;
    @ManyToMany
    @JoinTable(name = "rent_service", joinColumns = @JoinColumn(name = "rent_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<UserService> services;
    private String feedback;


    public RentDetail() {
    }

    public RentDetail(Rent rent, Set<UserService> services, String feedback) {
        this.rent = rent;
        this.services = services;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Set<UserService> getServices() {
        return services;
    }

    public void setServices(Set<UserService> services) {
        this.services = services;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

