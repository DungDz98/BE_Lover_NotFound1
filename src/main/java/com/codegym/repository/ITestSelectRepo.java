package com.codegym.repository;

import com.codegym.model.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITestSelectRepo extends JpaRepository<UserTest, Long> {
    @Query(value = "select user.id, user.name, user.avatar, user.description, SUBSTRING_INDEX(GROUP_CONCAT(category.name SEPARATOR ' - '), ' - ', 3) AS category_name , user.price from category  inner join user_service on user_service.service_id = category.id  inner join user on user.id = user_service.user_id and user.statusccdv = 1 GROUP BY ID", nativeQuery = true)
    public Iterable<UserTest> findAllTest();
}
