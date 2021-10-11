package com.codegym.service.userService;

import com.codegym.model.entity.UserService;
import com.codegym.repository.IUserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class User_Service extends UserService implements IUser_Service {
    @Autowired
    IUserServiceRepository iUserServiceRepository;

    @Override
    public Iterable<UserService> findAll() {
        return iUserServiceRepository.findAll();
    }

    @Override
    public Optional<UserService> findById(Long id) {
        return iUserServiceRepository.findById(id);
    }

    @Override
    public UserService save(UserService userSevice) {
        return iUserServiceRepository.save(userSevice);
    }

    @Override
    public void remove(Long id) {
        iUserServiceRepository.deleteById(id);
    }

    @Override
    public Iterable<UserService> findAllByUserId(Long id) {
        return iUserServiceRepository.findAllByUserId(id);
    }
}
