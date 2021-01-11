package com.ktwlrj.dectation.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    @ApiModelProperty(name = "id", value = "用户id")
    private int id;

    @NotBlank
    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @NotBlank
    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @NotBlank
    @ApiModelProperty(name = "name", value = "名字")
    private String name;

    @ApiModelProperty(name = "createAt", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime createAt;
}
