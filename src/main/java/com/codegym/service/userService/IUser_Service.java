package com.codegym.service.userService;

import com.codegym.model.entity.UserSevice;
import com.codegym.service.IGeneralService;

public interface IUser_Service extends IGeneralService<UserSevice> {
    Iterable<UserSevice> findAllByUserId (Long id);
}
