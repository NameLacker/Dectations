package com.ktwlrj.dectation.modules.service.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@Accessors
@AllArgsConstructor
public class InformationDto {

    @ApiModelProperty(name = "id", value = "索引id")
    private int id;

    @ApiModelProperty(name = "name", value = "名字")
    private String name;

    @ApiModelProperty(name = "age", value = "年龄")
    private int age;

    @ApiModelProperty(name = "gender", value = "性别")
    private String gender;

    @ApiModelProperty(name = "score", value = "分数")
    private int score;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @ApiModelProperty(name = "createAt", value = "创建时间")
    private BigInteger createAt;
}
