package com.liqingitt.exam_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liqingitt.exam_system.dao.User;
import com.liqingitt.exam_system.dto.accountCenter.UserCreateReq;
import com.liqingitt.exam_system.dto.accountCenter.UserLoginReq;


public interface UserService extends IService<User> {

    Void register(UserCreateReq user);

    User login(UserLoginReq userLoginReq);

}
