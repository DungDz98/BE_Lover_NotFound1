package com.codegym.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_CCDV")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_SDDV")
    private User userRent;
    private Date rentDate;
    private Date startTime;
    private double totalMoney;
    private double time;

    // Trạng thái của đơn thuê: 0: chờ CCDV phản hồi, 1: Đã nhận, 2:Đã hoàn thành 3.Đã nhận tiền 4. Đã gửi báo cáo
    private int status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rent_service", joinColumns = @JoinColumn(name = "rent_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Category> services;
    private String feedback;


    public Rent() {
    }

    public Rent(User user, User userRent, Date rentDate, Date startTime, double totalMoney, double time, int status) {
        this.user = user;
        this.userRent = userRent;
        this.rentDate = rentDate;
        this.startTime = startTime;
        this.totalMoney = totalMoney;
        this.time = time;
        this.status = status;
    }

    public Rent(User user, User userRent, Date rentDate, Date startTime, double totalMoney, double time, int status, Set<Category> services, String feedback) {
        this.user = user;
        this.userRent = userRent;
        this.rentDate = rentDate;
        this.startTime = startTime;
        this.totalMoney = totalMoney;
        this.time = time;
        this.status = status;
        this.services = services;
        this.feedback = feedback;
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

    public User getUserRent() {
        return userRent;
    }

    public void setUserRent(User userRent) {
        this.userRent = userRent;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Category> getServices() {
        return services;
    }

    public void setServices(Set<Category> services) {
        this.services = services;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
