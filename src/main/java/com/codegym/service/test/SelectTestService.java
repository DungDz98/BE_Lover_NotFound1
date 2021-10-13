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

    @Override
    public Iterable<UserTest> findAllUserCCDV() {
        return selectTestRepo.findAllByCCDV();
    }

    @Override
    public Iterable<UserTest> findAllUserCCDVByGender(String gender) {
        return selectTestRepo.findAllUserCCDVByGender(gender);
    }

    @Override
    public Iterable<UserTest> findAllByCity(String city) {
        return selectTestRepo.findAllByCity(city);
    }

    @Override
    public Iterable<UserTest> findAllByName(String name) {
        return selectTestRepo.findAllByName(name);
    }

    @Override
    public Iterable<UserTest> findAllByGoiY(String gender) {
        return selectTestRepo.findAllByGoiY(gender);
    }
}
