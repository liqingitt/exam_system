package com.liqingitt.exam_system.dto.answerPaper;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "答卷对象")
public class AnswerPaperBasis implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(description = "主键id")
     private Long id;
     

    @Schema(description = "答题用户id")
    private Long answerUserId;

    @Schema(description = "试卷id")
    private Long examId;

    @Schema(description = "逻辑删除")
    private int logicDelete;

    @Schema(description = "答卷内容")
    private String content;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;


}
