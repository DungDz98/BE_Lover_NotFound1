package com.codegym.service.test;

import com.codegym.model.entity.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserSecondService implements IUserSecondService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }
}
