package com.codegym.repository;

import com.codegym.model.entity.UserSevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserServiceRepository extends JpaRepository<UserSevice,Long> {
    @Query("select us from UserSevice us where us.user.id =:id")
    Iterable<UserSevice> findAllByUserId (Long id);
}
