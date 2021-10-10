package com.codegym.dto.request;

import com.codegym.model.entity.Category;
import com.codegym.model.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class RentWithoutServices {
    private User user;
    private User userRent;
    private Date rentDate;
    private Date startTime;
    private double totalMoney;
    private double time;

    // Trạng thái của đơn thuê: 0: chờ CCDV phản hồi, 1: Đã nhận, 2:Đã hoàn thành 3.Đã nhận tiền 4. Đã gửi báo cáo
    private int status;
    private Set<String> services;
    private String feedback;

    public RentWithoutServices() {
    }

    public RentWithoutServices(User user, User userRent, Date rentDate, Date startTime, double totalMoney, double time, int status, Set<String> services, String feedback) {
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

    public Set<String> getServices() {
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
