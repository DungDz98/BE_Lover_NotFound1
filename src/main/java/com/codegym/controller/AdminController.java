package com.codegym.controller;

import com.codegym.model.entity.Category;
import com.codegym.model.entity.Rent;
import com.codegym.model.entity.RentDetail;
import com.codegym.model.entity.User;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.rent.IRentService;
import com.codegym.service.rentdetail.IRentDetailService;
import com.codegym.service.user.IUserService;
import com.codegym.service.userService.IUser_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IUserService userService;
    @Autowired
    IUser_Service user_service;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IRentService rentService;
    @Autowired
    IRentDetailService rentDetailService;
@GetMapping("/users")
    public ResponseEntity<Iterable<User>> findAllUser(){
Iterable<User> users = userService.findAll();
return new ResponseEntity<>(users, HttpStatus.OK);
}
    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        Iterable<Category> categoryServices = categoryService.findAll();
        return new ResponseEntity(categoryServices,HttpStatus.OK);
    }
    @GetMapping("/rent")
    public ResponseEntity<Iterable<Rent>> getAllRent(){
        Iterable<Rent> rents = rentService.findAll();
        return new ResponseEntity<>(rents,HttpStatus.OK);
    }
    @GetMapping("/rentDetail/{id}")
    public ResponseEntity<Iterable<RentDetail>> findAllByRentId(@PathVariable Long id){
        Iterable<RentDetail> rent_details = rentDetailService.findByRentId(id);
        return new ResponseEntity<>(rent_details,HttpStatus.OK);
    }
    @GetMapping("/rent/{id}")
    public ResponseEntity<Rent> findById(@PathVariable Long id){
        Optional<Rent> rentOptional = rentService.findById(id);
        return new ResponseEntity(rentOptional,HttpStatus.OK);
    }
@GetMapping("/transaction")
    public ResponseEntity<Iterable<Rent>> findRentByStatus(){
    Iterable<Rent> rents = rentService.findRentByStatus();
    return new ResponseEntity<>(rents, HttpStatus.OK);
}
}
