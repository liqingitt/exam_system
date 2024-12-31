package com.liqingitt.exam_system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liqingitt.exam_system.dao.User;
import com.liqingitt.exam_system.mapper.UserMapper;
import com.liqingitt.exam_system.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
