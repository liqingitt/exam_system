package com.liqingitt.exam_system.dto.examPaper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "试卷对象")
public class ExamPaperUpdateReq {

    @Schema(description = "主键id")
    @NotNull
    private Long id;

    @Schema(description = "创建用户的id")
    @NotNull
    private Long createUserId;

    @NotEmpty
    @Schema(description = "试卷名称")
    private String name;

    @Schema(description = "是否发布")
    private int isPublish;

    @Schema(description = "是否删除")
    private int logicDelete;

    @Schema(description = "试卷内容")
    private String content;
}
