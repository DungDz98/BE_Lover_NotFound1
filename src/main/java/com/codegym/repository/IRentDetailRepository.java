package com.codegym.repository;

import com.codegym.model.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentDetailRepository extends JpaRepository<RentDetail, Long> {
    @Query("select r from RentDetail r where r.rent.id =:id")
    Iterable<RentDetail> findByRentId(Long id);
}
