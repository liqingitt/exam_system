package com.liqingitt.exam_system.utils;

import com.liqingitt.exam_system.dto.accountCenter.UserBasis;
import com.liqingitt.exam_system.exceptions.BusinessException;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;

public class TokenUtils {

    public static final String loginSecret = "userLoginSecret";

    public static String createUserToken(UserBasis userBasis) {
        return JWTUtil.createToken(BeanUtil.beanToMap(userBasis), loginSecret.getBytes());
    }

    public static UserBasis parseUserToken(String token) {
        if (token == null) {
            throw new BusinessException("token 无效");
        }
        try {
            JWT jwt = JWTUtil.parseToken(token);
            JSONObject claimsJson = jwt.getPayload().getClaimsJson();
            return BeanUtil.toBean(claimsJson, UserBasis.class);
        } catch (Exception e) {
            throw new BusinessException("token 无效");
        }
    }

}
