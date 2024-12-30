package com.liqingitt.exam_system.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "试卷对象")
public class ExamPaperCreateReq {

    @Schema(description = "试卷名称")
    @NotBlank
    private String name;

    @Schema(description = "试卷内容")
    @NotBlank
    private String content;

}
