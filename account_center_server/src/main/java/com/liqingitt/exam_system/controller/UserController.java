package com.liqingitt.exam_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liqingitt.exam_system.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;

@RestController
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {

    @Resource
    UserService userService;

    @Operation(summary = "测试接口")
    @GetMapping("/dddd")
    public String getExamPaper() {
        return "Hello World";
    }

}