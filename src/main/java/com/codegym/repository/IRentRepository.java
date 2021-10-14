package com.codegym.repository;

import com.codegym.model.entity.Rent;
import com.codegym.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentRepository extends JpaRepository<Rent, Long> {
    @Query("select r from Rent r where r.user.id =:id")
    Iterable<Rent> findByUserId(Long id);

    @Query("select r from Rent r where r.userRent.id =:id")
    Iterable<Rent> findByUserRentId(Long id);

    @Query(value= "select * from Rent where status >=2",nativeQuery = true)
    Iterable<Rent> findRentByStatus();

    @Query(value= "select * from Rent where status >=2 and user_ccdv = :id",nativeQuery = true)
    Iterable<Rent> findRentByStatusAndId(Long id);


}
