package com.codegym.repository;

import com.codegym.model.entity.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserServiceRepository extends JpaRepository<UserService, Long> {
}
