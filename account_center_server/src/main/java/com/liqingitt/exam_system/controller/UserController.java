package com.liqingitt.exam_system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liqingitt.exam_system.dao.User;
import com.liqingitt.exam_system.dto.accountCenter.UserBasis;
import com.liqingitt.exam_system.dto.accountCenter.UserCreateReq;
import com.liqingitt.exam_system.dto.accountCenter.UserLoginReq;
import com.liqingitt.exam_system.exceptions.BusinessException;
import com.liqingitt.exam_system.service.UserService;
import com.liqingitt.exam_system.utils.Results;
import com.liqingitt.exam_system.utils.TokenUtils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/account-center/user")
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {

    @Resource
    UserService userService;

    @Value("${login-secret}")
    private String loginSecret;

    @Operation(summary = "测试接口")
    @GetMapping("/dddd")
    public String dddd() {
        return loginSecret;
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Results<Void> register(@Validated @RequestBody UserCreateReq userCreateReq) {
        userService.register(userCreateReq);
        return Results.success();
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Results<Void> login(
            @Validated @RequestBody UserLoginReq userLoginReq,
            HttpServletResponse response) {
        User user = userService.login(userLoginReq);
        UserBasis userBasis = new UserBasis();
        BeanUtil.copyProperties(user, userBasis);

        String token = TokenUtils.createUserToken(userBasis);

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7天过期
        cookie.setPath("/");
        response.addCookie(cookie);
        return Results.success();
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("/info")
    public Results<UserBasis> info(@CookieValue("token") String token) {
            UserBasis userBasis = TokenUtils.parseUserToken(token);
            return Results.success(userBasis);
    }

    @Operation(summary = "退出登录")
    @PostMapping("/logout")
    public Results<Void> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);
        return Results.success();
    }

}
