package com.codegym.service.user;

import com.codegym.model.entity.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public Iterable<User> findAllUserCCDV() {
        return userRepository.findAllByCCDV();
    }

    @Override
    public Iterable<User> findAllUserCCDVByGender(String gender) {
        return userRepository.findAllUserCCDVByGender(gender);
    }

    @Override
    public Iterable<User> findAllByCity(String city) {
        return userRepository.findAllByCity(city);
    }

    @Override
    public Iterable<User> findAllByAge(int ageFirst, int ageSecond) {
        return userRepository.findAllByAge(ageFirst, ageSecond);
    }

    @Override
    public Iterable<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public Iterable<User> findAllTest(String gender, String city, String name) {
        return userRepository.findAllTest(gender, city, name);
    }


}
