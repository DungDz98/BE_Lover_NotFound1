package com.codegym.repository;

import com.codegym.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from user where statusccdv = 1", nativeQuery = true)
    public Iterable<User> findAllByCCDV();

    @Query(value = "select * from user where statusccdv = 1 and gender like :gender and city like :city and name like concat('%',:name,'%')", nativeQuery = true)
    public Iterable<User> findAllTest(@Param("gender") String gender, @Param("city") String city, @Param("name") String name);

    @Query(value = "select * from user where statusccdv = 1 and gender like :gender", nativeQuery = true)
    public Iterable<User> findAllUserCCDVByGender(@Param("gender")String gender);

    @Query(value = "select * from user where statusccdv = 1 and city like :city", nativeQuery = true)
    public Iterable<User> findAllByCity(@Param("city") String city);

    @Query(value = "select * from user where statusccdv = 1 and ROUND(DATEDIFF(CURDATE(), tinder.user.date_of_birth) / 365, 0) between :ageFirst and :ageSecond", nativeQuery = true)
    public Iterable<User> findAllByAge(@Param("ageFirst") int ageFirst, @Param("ageSecond") int ageSecond);

    @Query(value = "select * from user where statusccdv = 1 and name like concat('%',:name,'%')", nativeQuery = true)
    public Iterable<User> findAllByName(@Param("name") String name);
}
