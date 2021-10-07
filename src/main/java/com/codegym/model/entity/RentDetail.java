package com.codegym.model.entity;

import javax.persistence.*;

@Entity
public class RentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Rent rent;
    @ManyToOne
    private Category service;
    // chưa cần thiết
    private double time;


    public RentDetail() {
    }

    public RentDetail(Rent rent, Category service, double time) {
        this.rent = rent;
        this.service = service;
        this.time = time;
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

    public Category getService() {
        return service;
    }

    public void setService(Category service) {
        this.service = service;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
