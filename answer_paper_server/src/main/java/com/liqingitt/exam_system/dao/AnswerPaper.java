package com.liqingitt.exam_system.dao;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("answer_paper")
public class AnswerPaper {
    private Long id;

    private Long answerUserId;

    private Long examId;

    @TableLogic
    private int logicDelete;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
