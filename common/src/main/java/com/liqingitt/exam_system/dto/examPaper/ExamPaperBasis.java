package com.liqingitt.exam_system.dto.examPaper;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "试卷对象")
public class ExamPaperBasis {

    @Schema(description = "主键id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Schema(description = "创建用户的id")
    private Long createUserId;

    @Schema(description = "试卷名称")
    private String name;

    @Schema(description = "是否发布")
    private int isPublish;

    @Schema(description = "是否删除")
    private int logicDelete;

    @Schema(description = "试卷内容")
    private String content;

    @Schema(description = "创建时间",type = "integer")
    private LocalDateTime createTime;

    @Schema(description = "更新时间",type = "integer")
    private LocalDateTime updateTime;
}
