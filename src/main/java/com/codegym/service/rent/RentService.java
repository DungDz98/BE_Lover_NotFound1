package com.codegym.service.rent;

import com.codegym.model.entity.Rent;
import com.codegym.model.entity.User;
import com.codegym.repository.IRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentService implements IRentService {
    @Autowired
    private IRentRepository rentRepository;
    @Override
    public Iterable<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Optional<Rent> findById(Long id) {
        return rentRepository.findById(id);
    }

    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void deleteById(Long id) {
        rentRepository.deleteById(id);
    }
    @Override
    public Iterable<Rent> findByUserId(Long id) {
        return rentRepository.findByUserId(id);
    }

    @Override
    public Iterable<Rent> findByUserRentId(Long id) {
        return rentRepository.findByUserRentId(id);
    }
    @Override
    public Iterable<Rent> findRentByStatus() {
        return rentRepository.findRentByStatus();
    }
}
