package com.codegym.controller;

import com.codegym.model.entity.User;
import com.codegym.model.entity.UserTest;
import com.codegym.service.test.ISelectTestService;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/selectByRequests")
public class SelectRequestController {
    @Autowired
    IUserService userService;

    @Autowired
    ISelectTestService selectTestService;


//....
    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUserCCDV(){
        return new ResponseEntity<>(userService.findAllUserCCDV(), HttpStatus.OK);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<Iterable<User>> findAllUserCCDVByGender(@PathVariable String gender){
        return new ResponseEntity<>(userService.findAllUserCCDVByGender(gender), HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<Iterable<User>> findAllByCity(@PathVariable String city){
        return new ResponseEntity<>(userService.findAllByCity(city), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<User>> findAllByName(@PathVariable String name){
        return new ResponseEntity<>(userService.findAllByName(name), HttpStatus.OK);
    }




//    @GetMapping("/findTest")
//    public ResponseEntity<Iterable<User>> findAllTest(@RequestBody String gender, String city, String name,  int ageFirst,  int ageSecond){
//        return new ResponseEntity<>(userService.findAllTest(gender, city, name, ageFirst, ageSecond), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<User> findAllTest(@RequestBody User user) {
        return new ResponseEntity(userService.findAllTest(user.getGender(), user.getCity(), user.getName()), HttpStatus.OK);
    }

    @GetMapping("/findTest")
    public ResponseEntity<User> findAll123(@RequestBody User user) {
        return new ResponseEntity(userService.findAllTest(user.getGender(), user.getCity(), user.getName()), HttpStatus.OK);
    }

    @PostMapping("/name")
    public ResponseEntity<Iterable<User>> findName(@RequestParam String name){
        return new ResponseEntity<>(userService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Iterable<UserTest>> findAllTest(){
        return new ResponseEntity<>(selectTestService.findAllTest(), HttpStatus.OK);
    }
}
