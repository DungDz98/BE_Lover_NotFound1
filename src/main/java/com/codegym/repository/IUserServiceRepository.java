package com.codegym.repository;

import com.codegym.model.entity.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserServiceRepository extends JpaRepository<UserService,Long> {
    @Query("select us from UserService us where us.user.id =:id")
    Iterable<UserService> findAllByUserId (Long id);
}
