package com.liqingitt.exam_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liqingitt.exam_system.service.AnswerPaperService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;


@RestController
@Tag(name = "答卷管理", description = "答卷管理接口")
@RequestMapping("/answer-paper")
public class AnswerPaperController {
    @Resource()
    private AnswerPaperService answerPaperService;  





}
