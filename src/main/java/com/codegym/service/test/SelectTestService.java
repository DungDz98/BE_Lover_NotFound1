package com.codegym.service.test;


import com.codegym.model.entity.UserTest;
import com.codegym.repository.ITestSelectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectTestService implements ISelectTestService{
    @Autowired
    ITestSelectRepo selectTestRepo;

    @Override
    public Iterable<UserTest> findAllTest() {
        return selectTestRepo.findAllTest();
    }
}
