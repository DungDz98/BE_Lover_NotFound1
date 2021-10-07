package com.codegym.service.user;

import com.codegym.model.entity.User;


public interface IUserService {
    Iterable<User> findAllUserCCDV();
    Iterable<User> findAllTest(String gender, String city, String name);
    Iterable<User> findAllUserCCDVByGender(String gender);

    Iterable<User> findAllByCity(String city);
    Iterable<User> findAllByAge(int ageFirst, int ageSecond);
    Iterable<User> findAllByName(String name);
}
