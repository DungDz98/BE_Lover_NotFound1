package com.codegym.controller;

import com.codegym.model.entity.UserSevice;
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
    @GetMapping("")
    public ResponseEntity<Iterable<UserSevice>> findAll() {
        return new ResponseEntity<>(user_service.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Optional<UserSevice>> create(@RequestBody UserSevice userservice) {
        userservice.setPrice(0);
        user_service.save(userservice);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<UserSevice>> findByUserId(@PathVariable Long id) {
        Iterable<UserSevice> user_services = user_service.findAllByUserId(id);
        return new ResponseEntity<>(user_services, HttpStatus.OK);
    }
    @GetMapping("/findOne/{id}")
    public ResponseEntity<UserSevice> findOne(@PathVariable Long id) {
        Optional<UserSevice> user_services = user_service.findById(id);
        return new ResponseEntity<>(user_services.get(), HttpStatus.OK);
    }
}
