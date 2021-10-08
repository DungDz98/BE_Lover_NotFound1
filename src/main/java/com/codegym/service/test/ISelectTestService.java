package com.codegym.service.test;

import com.codegym.model.entity.UserTest;

import java.util.ArrayList;

public interface ISelectTestService {
    public Iterable<UserTest> findAllTest();
}
