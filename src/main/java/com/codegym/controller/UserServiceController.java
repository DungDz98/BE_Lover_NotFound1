package com.codegym.controller;

import com.codegym.model.entity.UserService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.userService.IUser_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/userservices")
public class UserServiceController {
    @Autowired
    IUser_Service user_service;
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<Iterable<UserService>> findAll() {
        return new ResponseEntity<>(user_service.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<UserService> create(@RequestBody UserService userservice) {
        if (userservice.getCategory().getTypeService().equals("basic")) userservice.setPrice(0);
        else userservice.setPrice(70);
        return new ResponseEntity<>(user_service.save(userservice), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<UserService>> findByUserId(@PathVariable Long id) {
        Iterable<UserService> user_services = user_service.findAllByUserId(id);
        return new ResponseEntity<>(user_services, HttpStatus.OK);
    }
    @GetMapping("/findOne/{id}")
    public ResponseEntity<UserService> findOne(@PathVariable Long id) {
        Optional<UserService> user_services = user_service.findById(id);
        return new ResponseEntity<>(user_services.get(), HttpStatus.OK);
    }
}
