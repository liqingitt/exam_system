package com.liqingitt.exam_system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liqingitt.exam_system.dao.User;
import com.liqingitt.exam_system.dto.accountCenter.UserCreateReq;
import com.liqingitt.exam_system.dto.accountCenter.UserLoginReq;
import com.liqingitt.exam_system.exceptions.BusinessException;
import com.liqingitt.exam_system.mapper.UserMapper;
import com.liqingitt.exam_system.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Void register(UserCreateReq userCreateReq) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, userCreateReq.getUsername());

        long count = this.count(queryWrapper);

        if (count > 0) {
            throw new BusinessException("用户已存在");
        }

        User user = new User();
        user.setUsername(userCreateReq.getUsername());
        user.setPassword(userCreateReq.getPassword());
        user.setEmail(userCreateReq.getEmail());
        this.save(user);

        return null;
    }

    @Override
    public User login(UserLoginReq userLoginReq) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, userLoginReq.getUsername());
        lambdaQueryWrapper.eq(User::getPassword, userLoginReq.getPassword());
        User user = this.getOne(lambdaQueryWrapper);
        if (user == null) {
            throw new BusinessException("用户名或密码错误");
        }
        return user;
    }

}
