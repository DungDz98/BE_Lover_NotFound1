package com.codegym.repository;

import com.codegym.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String username);

    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String username);

//    Tìm tất cả người CCDV
    @Query("select us from User us where us.statusCCDV =1 or us.statusCCDV =2")
    Iterable<User> findAllByStatusCCDV();

    @Query("select us from User us where us.statusUs =0 or us.statusUs =1 or us.statusUs =2")
    Iterable<User> findAllUser();

    @Query("select us from User us where us.statusCCDV =1 and us.id= :id")
    Optional<User> findCCDVById(Long id);

    @Query(value = "select * from User where (statusccdv = 1 or statusccdv = 2) order by create_atccdv desc limit 12", nativeQuery = true)
    Iterable<User> find12NewCCDV();

    @Query("select us from User us where (us.statusCCDV =1 or us.statusCCDV = 2) and us.name like ?1")
    Iterable<User> findAllByNameContaining(String name);

    @Query("select us from User us where (us.statusCCDV = 1 or us.statusCCDV = 2) and us.gender like ?1")
    Iterable<User> findAllByGenderContaining(String gender);

    @Query("select us from User us where (us.statusCCDV =1 or us.statusCCDV = 2) and us.city= :city")
    Iterable<User> findAllByCityContaining(String city);

    @Query(value = "select * from User where user.id in (select Message.sender_id from Message where Message.receiver_id=?1) or user.id in (select Message.receiver_id from Message where Message.sender_id=?1)", nativeQuery = true)
    Iterable<User> findUserByMessage(Long id);

    @Query("select us from User us where us.statusCCDV =3")
    Iterable<User> findAllByStatus3();

    @Query("select us from User us where us.statusUs =2 and (us.statusCCDV = 2 or us.statusCCDV =1)")
    Iterable<User> findAllVipUser();

    @Query("select us from User us where us.statusCCDV =0")
    Iterable<User> findAllByUserSDDV();


}
