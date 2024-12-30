package com.liqingitt.exam_system.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liqingitt.exam_system.dao.AnswerPaper;
import com.liqingitt.exam_system.dto.AnswerPaperBasis;
import com.liqingitt.exam_system.dto.AnswerPaperCreate;
import com.liqingitt.exam_system.service.AnswerPaperService;
import com.liqingitt.exam_system.utils.Results;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;


@RestController
@Tag(name = "答卷管理", description = "答卷管理接口")
@RequestMapping("/answer-paper")
public class AnswerPaperController {
    @Resource()
    private AnswerPaperService answerPaperService;  

    @PostMapping("/create")
    @Operation(summary = "创建答卷", description = "创建答卷")
    public Results<Void> create(@RequestBody @Valid AnswerPaperCreate answerPaperCreate) {
        AnswerPaper answerPaper = new AnswerPaper();
        BeanUtils.copyProperties(answerPaperCreate, answerPaper);
        answerPaperService.save(answerPaper);
        return Results.success();
    }




}