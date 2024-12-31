package com.liqingitt.exam_system.dto.answerPaper;
import com.liqingitt.exam_system.utils.PageReqDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "答卷分页请求")
public class AnswerPaperPageReq  extends PageReqDto{
    @Schema(description = "试卷id")
    @NotNull(message = "试卷id不能为空")
    private Long examPaperId;
}
