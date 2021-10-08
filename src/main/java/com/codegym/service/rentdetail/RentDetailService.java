package com.codegym.service.rentdetail;

import com.codegym.model.entity.RentDetail;
import com.codegym.repository.IRentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentDetailService implements IRentDetailService {
    @Autowired
    IRentDetailRepository rentDetailRepository;
    @Override
    public Iterable<RentDetail> findAll() {
        return rentDetailRepository.findAll();
    }

    @Override
    public Optional<RentDetail> findById(Long id) {
        return rentDetailRepository.findById(id);
    }

    @Override
    public RentDetail save(RentDetail rentDetail) {
        return rentDetailRepository.save(rentDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
