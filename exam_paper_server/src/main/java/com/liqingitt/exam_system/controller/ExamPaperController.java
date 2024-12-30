package com.liqingitt.exam_system.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liqingitt.exam_system.dao.ExamPaper;
import com.liqingitt.exam_system.dto.ExamPaperBasis;
import com.liqingitt.exam_system.dto.ExamPaperBasisListReq;
import com.liqingitt.exam_system.dto.ExamPaperCreateReq;
import com.liqingitt.exam_system.dto.ExamPaperUpdateReq;
import com.liqingitt.exam_system.service.ExamPaperService;
import com.liqingitt.exam_system.utils.PageReqDto;
import com.liqingitt.exam_system.utils.PageResDto;
import com.liqingitt.exam_system.utils.Results;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/exam-paper")
@Tag(name = "试卷管理", description = "试卷管理相关接口")
public class ExamPaperController {

    @Resource
    ExamPaperService examPaperService;

    @Operation(summary = "测试接口")
    @GetMapping("/dddd")
    public String getExamPaper() {
        return "Hello World";
    }

    @Operation(summary = "分页查询试卷列表")
    @GetMapping("/list")
    public Results<PageResDto<ExamPaperBasis>> list(ExamPaperBasisListReq examBasisListReq) {

        Page<ExamPaper> examPage = PageReqDto.toPageObj(examBasisListReq);

        LambdaQueryWrapper<ExamPaper    > examLambdaQueryWrapper = new LambdaQueryWrapper<>();

        examLambdaQueryWrapper.like(
                StringUtils.hasText(examBasisListReq.getName()),
                ExamPaper::getName, examBasisListReq.getName());

        Page<ExamPaper> page = examPaperService.page(examPage, examLambdaQueryWrapper);

        List<ExamPaper> records = page.getRecords();

        List<ExamPaperBasis> examBasisList = records.stream().map(exam -> {
            ExamPaperBasis examBasis = new ExamPaperBasis();
            BeanUtils.copyProperties(exam, examBasis);
            return examBasis;
        }).toList();


        PageResDto<ExamPaperBasis> examBasisPageResDto = new PageResDto<>();

        examBasisPageResDto.setTotal(page.getTotal());
        examBasisPageResDto.setCurrentPage(examPage.getCurrent());
        examBasisPageResDto.setPageSize(examPage.getSize());
        examBasisPageResDto.setData(examBasisList);

        return Results.success(examBasisPageResDto);
    }

    @Operation(summary = "新增试卷")
    @PostMapping("/add")
    public Results<Void> add(@Validated @RequestBody ExamPaperCreateReq examCreateReq) {
        ExamPaper examPaper = new ExamPaper();
        BeanUtils.copyProperties(examCreateReq, examPaper);
        examPaper.setCreateUserId(1L);
        examPaperService.save(examPaper);
        return Results.success();
    }
    @Operation(summary = "更新试卷")
    @PostMapping("/update")
    public Results<Void> update(@Validated @RequestBody ExamPaperUpdateReq examUpdateReq) {
        ExamPaper examPaper = new ExamPaper();
        BeanUtils.copyProperties(examUpdateReq, examPaper);
        examPaperService.updateById(examPaper);
        return Results.success();
    }

    @Operation(summary = "删除试卷")
    @DeleteMapping("/delete")
    public Results<Void> delete(@NotNull Long id) {
        examPaperService.removeById(id);
        return Results.success();
    }

    @Operation(summary = "查询试卷详情")
    @GetMapping("/detail")
    public Results<ExamPaper> detail(@NotNull Long id) {
        ExamPaper examPaper = examPaperService.getById(id);
        return Results.success(examPaper);
    }
}
