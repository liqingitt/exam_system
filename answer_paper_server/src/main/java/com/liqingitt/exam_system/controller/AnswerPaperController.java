package com.liqingitt.exam_system.controller;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liqingitt.exam_system.dao.AnswerPaper;
import com.liqingitt.exam_system.dto.AnswerPaperBasis;
import com.liqingitt.exam_system.dto.AnswerPaperCreate;
import com.liqingitt.exam_system.dto.AnswerPaperPageReq;
import com.liqingitt.exam_system.service.AnswerPaperService;
import com.liqingitt.exam_system.utils.PageResDto;
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

    @GetMapping("/getAnswerPaperListByExamPaperId")
    @Operation(summary = "根据试卷id获取答卷列表", description = "根据试卷id获取答卷列表")
    public Results<PageResDto<AnswerPaperBasis>> getAnswerPaperByExamPaperId(AnswerPaperPageReq answerPaperPageReq) {

        Page<AnswerPaper> page = AnswerPaperPageReq.toPageObj(answerPaperPageReq);

        LambdaQueryWrapper<AnswerPaper> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.eq(AnswerPaper::getExamId, answerPaperPageReq.getExamPaperId());

       answerPaperService.page(page, lambdaQueryWrapper);

        PageResDto<AnswerPaperBasis> pageResDto = new PageResDto<>();
        
        pageResDto.setCurrentPage(page.getCurrent());
        pageResDto.setPageSize(page.getSize());
        pageResDto.setTotal(page.getTotal());
        pageResDto.setData(page.getRecords().stream().map(answerPaper -> {
            AnswerPaperBasis answerPaperBasis = new AnswerPaperBasis();
            BeanUtils.copyProperties(answerPaper, answerPaperBasis);
            return answerPaperBasis;
        }).collect(Collectors.toList()));

        return Results.success(pageResDto);
    }

}