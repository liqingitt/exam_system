package com.liqingitt.exam_system.dto.examPaper;

import com.liqingitt.exam_system.utils.PageReqDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "试卷列表查询参数")
public class ExamPaperBasisListReq extends PageReqDto {
    @Schema(description = "试卷名称")
//    @NotBlank(message = "试卷名称不能为空")
    private String name;
}
