package com.codegym.controller;


import com.codegym.model.entity.SelectTest;
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

    //.
    @GetMapping
    public ResponseEntity<Iterable<UserTest>> findAllUserCCDV() {
        return new ResponseEntity<>(selectTestService.findAllUserCCDV(), HttpStatus.OK);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<Iterable<UserTest>> findAllUserCCDVByGender(@PathVariable String gender) {
        return new ResponseEntity<>(selectTestService.findAllUserCCDVByGender(gender), HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<Iterable<UserTest>> findAllByCity(@PathVariable String city) {
        return new ResponseEntity<>(selectTestService.findAllByCity(city), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<UserTest>> findAllByName(@PathVariable String name) {
        return new ResponseEntity<>(selectTestService.findAllByName(name), HttpStatus.OK);
    }


//    @GetMapping("/findTest")
//    public ResponseEntity<Iterable<User>> findAllTest(@RequestBody String gender, String city, String name,  int ageFirst,  int ageSecond){
//        return new ResponseEntity<>(userService.findAllTest(gender, city, name, ageFirst, ageSecond), HttpStatus.OK);
//

    @PostMapping("/name")
    public ResponseEntity<Iterable<UserTest>> findName(@RequestParam String name) {
        return new ResponseEntity<>(selectTestService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Iterable<UserTest>> findAllTest() {
        return new ResponseEntity<>(selectTestService.findAllTest(), HttpStatus.OK);
    }

    //list goi y
    @GetMapping("/suggestions")
    public ResponseEntity<Iterable<UserTest>> findAllGoiY(@RequestParam String gender) {
        if (gender.equals("Nu")) {
            return new ResponseEntity<>(selectTestService.findAllByGoiY("Nam"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(selectTestService.findAllByGoiY("Nu"), HttpStatus.OK);
        }
    }
    //list vip user
    @GetMapping("/vipUser")
    public ResponseEntity<Iterable<UserTest>> findAllVipUser(){
        return new ResponseEntity<>(selectTestService.findAllVipUser(), HttpStatus.OK);
    }

    //select nhieu truong
    @PostMapping("/getManyFiled")
    public ResponseEntity<Iterable<UserTest>> findAllByField(@RequestBody SelectTest selectTest){
        return new ResponseEntity<>(selectTestService.findAllByField(selectTest.getGender(), selectTest.getCity1(),selectTest.getName()), HttpStatus.OK);
    }
}
