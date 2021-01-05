package com.ktwlrj.dectation.modules.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Accessors
public class Student implements Serializable {

    @ApiModelProperty(name = "id", value = "配置id")
    private Integer id;

    private String name;

    private Integer score;

    private Integer age;

    private String gender;
}
