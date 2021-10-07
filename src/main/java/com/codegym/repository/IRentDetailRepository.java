package com.codegym.repository;

import com.codegym.model.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentDetailRepository extends JpaRepository<RentDetail, Long> {
}
