package com.codegym.controller;

import com.codegym.model.entity.User;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUser() {
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/users/statusUs/{id}")
    public ResponseEntity<User> changeStatusUserbyId(@PathVariable Long id, @RequestParam int statusUs){
        Optional<User> user = userService.findById(id);
        user.get().setStatusUs(statusUs);
        userService.save(user.get());
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }

    @PutMapping("/users/vip/{id}")
    public ResponseEntity<User> setVipById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.get().getStatusCCDV() == 3) user.get().setStatusCCDV(2);
        else user.get().setStatusCCDV(3);
        userService.save(user.get());
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }

}
