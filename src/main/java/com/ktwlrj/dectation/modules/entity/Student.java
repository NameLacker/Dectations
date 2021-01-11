package com.ktwlrj.dectation.modules.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Student implements Serializable {

    @ApiModelProperty(name = "id", notes = "学生id")
    private int id;

    @NotBlank
    @ApiModelProperty(name = "name", notes = "学生名字")
    private String name;

    @ApiModelProperty(name = "score", notes = "分数")
    private Integer score;

    @ApiModelProperty(name = "age", notes = "年龄")
    private Integer age;

    @ApiModelProperty(name = "gender", notes = "性别")
    private String gender;
}
