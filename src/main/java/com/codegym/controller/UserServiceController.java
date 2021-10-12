package com.codegym.controller;

import com.codegym.model.entity.UserService;
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
    public ResponseEntity<Iterable<UserService>> findAll() {
        return new ResponseEntity<>(user_service.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Optional<UserService>> create(@RequestBody UserService userservice) {
        userservice.setPrice(0);
        user_service.save(userservice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<UserService>> findByUserId(@PathVariable Long id) {
        Iterable<UserService> user_services = user_service.findAllByUserId(id);
        return new ResponseEntity<>(user_services, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<UserService>> update(@PathVariable Long id, @RequestBody UserService userservice) {
        Optional<UserService> user_service1 = user_service.findById(id);
        userservice.setId(id);
        userservice.setService(user_service1.get().getService());
        userservice.setUser(user_service1.get().getUser());
        user_service.save(userservice);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
