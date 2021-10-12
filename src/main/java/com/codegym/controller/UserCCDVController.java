package com.codegym.controller;

import com.codegym.model.entity.User;
import com.codegym.service.user.IUserService;
import com.codegym.service.userService.IUser_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/ccdv")
@CrossOrigin("*")
public class UserCCDVController {
@Autowired
    IUser_Service user_service;
@Autowired
    IUserService userService;
    @GetMapping("") 
    public ResponseEntity<Iterable<User>> findAll() {
        Iterable<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);

        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user.setId(id);
//        if (user.getName() == null) {
//        } else if (user.getName().trim().equals("")) {
//            if (userOptional.get().getName() != "") {
//                user.setName(userOptional.get().getName());
//            } else {
//                userOptional.get().setName(user.getName());   
//            }
//        }
        if (user.getName() == null) {
        } else if (user.getName().trim().equals("") || (userOptional.get().getName() != null && user.getName() == null)) {
            user.setName(userOptional.get().getName());
        }
        user.setUserName(userOptional.get().getUserName());
        user.setEmail(userOptional.get().getEmail());
        user.setPhoneNumber(userOptional.get().getPhoneNumber());
        user.setPassword(userOptional.get().getPassword());
        user.setAvatar(userOptional.get().getAvatar());
        if (user.getCity() == null) {
        } else if (user.getCity().trim().equals("") || (user.getCity() == null && userOptional.get().getCity() != null)) {
            user.setCity(userOptional.get().getCity());
        }
        if (user.getDescription() == null) {
        } else if (user.getDescription().trim().equals("") || (user.getDescription() == null && userOptional.get().getDescription() != null))
            user.setDescription(userOptional.get().getDescription());
        if (user.getHeight() == null) {
        } else if (user.getHeight().trim().equals("") || (user.getHeight() == null && userOptional.get().getHeight() != null))
            user.setHeight(userOptional.get().getHeight());
        if (user.getGender() == null) {
        } else if (user.getGender().trim().equals("") || (user.getGender() == null && userOptional.get().getGender() != null))
            user.setGender(userOptional.get().getGender());
        if (user.getHobby() == null) {
        } else if (user.getHobby().trim().equals("") || (user.getHobby() == null && userOptional.get().getHobby() != null))
            user.setHobby(userOptional.get().getHobby());
        if (user.getRequestToPayer() == null) {
        } else if (user.getRequestToPayer().trim().equals("") || (user.getRequestToPayer() == null && userOptional.get().getRequestToPayer() != null))
            user.setRequestToPayer(userOptional.get().getRequestToPayer());
        if (user.getNationality() == null) {
        } else if (user.getNationality().trim().equals("") || (user.getNationality() == null && userOptional.get().getNationality() != null))
            user.setNationality(userOptional.get().getNationality());
        user.setStatusCCDV(userOptional.get().getStatusCCDV());
        user.setStatusUs(userOptional.get().getStatusUs());
        user.setCreateAt(userOptional.get().getCreateAt());
        user.setRoles(userOptional.get().getRoles());
        if (user.getLinkFb() == null) {
        } else if (user.getLinkFb().trim().equals("") || (user.getLinkFb() == null && userOptional.get().getLinkFb() != null))
            user.setLinkFb(userOptional.get().getLinkFb());
        user.setCreateAtCCDV(new Date());
        user.setCreateAt(new Date());
        user.setStatusCCDV(1);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/statusccdv/{id}")
    public ResponseEntity<User> changeStatusCCDV(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        user.get().setId(id);
        if (user.get().getStatusCCDV() == 1) {
            user.get().setStatusCCDV(2);
        }else {
            user.get().setStatusCCDV(1);
        }
        userService.save(user.get());
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
@GetMapping("/{id}")
public ResponseEntity<User> findById(@PathVariable Long id) {
    Optional<User> userOptional = userService.findById(id);

    if (!userOptional.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
}

}
