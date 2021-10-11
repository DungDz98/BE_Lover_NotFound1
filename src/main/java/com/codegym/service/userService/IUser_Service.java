package com.codegym.service.userService;

import com.codegym.model.entity.UserService;
import com.codegym.service.IGeneralService;

public interface IUser_Service extends IGeneralService<UserService> {
    Iterable<UserService> findAllByUserId (Long id);
}
