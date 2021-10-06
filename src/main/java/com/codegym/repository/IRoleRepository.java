package com.codegym.repository;

import com.codegym.model.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<Role,Long> {

    Optional<Role> findByName(String name);
}
