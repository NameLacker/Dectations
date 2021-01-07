package com.ktwlrj.dectation.modules.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    @ApiModelProperty(name = "id", value = "用户id")
    private BigInteger id;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @ApiModelProperty(name = "name", value = "名字")
    private String name;

    @ApiModelProperty(name = "createAt", value = "创建时间")
    private long createAt;
}
