package com.codegym.service.userService;

import com.codegym.model.entity.UserService;
import com.codegym.repository.IUserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class User_Service extends UserService implements IUser_Service {
@Autowired
IUser_Service user_service;
    @Override
    public Iterable<UserService> findAll() {
        return user_service.findAll();
    }

    @Override
    public Optional<UserService> findById(Long id) {
        return user_service.findById(id);
    }

    @Override
    public UserService save(UserService userService) {
        return user_service.save(userService);
    }

    @Override
    public void remove(Long id) {
    user_service.remove(id);
    }

    @Override
    public Iterable<UserService> findAllByUserId(Long id) {
        return user_service.findAllByUserId(id);
    }
}
