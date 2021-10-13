package com.codegym.service.test;

import com.codegym.model.entity.UserTest;

import java.util.ArrayList;

public interface ISelectTestService {
    public Iterable<UserTest> findAllTest();

    Iterable<UserTest> findAllUserCCDV();
    Iterable<UserTest> findAllUserCCDVByGender(String gender);

    Iterable<UserTest> findAllByCity(String city);
    Iterable<UserTest> findAllByName(String name);

    Iterable<UserTest> findAllByGoiY(String gender);
}
