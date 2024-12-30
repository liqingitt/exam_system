package com.liqingitt.exam_system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "答卷创建对象")
public class AnswerPaperCreate {

    @Schema(description = "答题用户id")
    private Long answerUserId;

    @Schema(description = "试卷id")
    @NotNull(message = "试卷id不能为空")
    private Long examId;

    @Schema(description = "答卷内容")
    @NotNull(message = "答卷内容不能为空")
    private String content;

}
