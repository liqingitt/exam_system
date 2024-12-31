package com.liqingitt.exam_system.dao;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("user")
@Data
public class User {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 0 为正常状态 1 为停用状态
     */
    private Integer status;

    /**
     * 0 为未删除，1为已删除
     */
    @TableLogic
    private Integer logicDelete;

    /**
     * 邮箱
     */
    private String email;
    

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
