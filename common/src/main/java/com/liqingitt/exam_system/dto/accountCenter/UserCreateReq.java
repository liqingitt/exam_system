package com.liqingitt.exam_system.dto.accountCenter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "用户创建请求对象")
public class UserCreateReq {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Schema(description = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

}
