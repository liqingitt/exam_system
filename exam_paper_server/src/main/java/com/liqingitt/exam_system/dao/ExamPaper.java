package com.liqingitt.exam_system.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("exam_paper")
@Data
public class ExamPaper implements Serializable {

    private Long id;

    private Long createUserId;

    private String name;

    private int isPublish;

    @TableLogic
    private int logicDelete;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}