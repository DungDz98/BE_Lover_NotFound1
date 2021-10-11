package com.codegym.service.rent;

import com.codegym.model.entity.Rent;
import com.codegym.model.entity.User;
import com.codegym.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

public interface IRentService extends IGeneralService<Rent> {
    Iterable<Rent> findByUserId(Long id);
    Iterable<Rent> findByUserRentId(Long id);
    void deleteById(Long id);
}
