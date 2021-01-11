package com.ktwlrj.dectation.modules.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigInteger;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Accessors(chain = true)
public class Developer implements Serializable {

    @ApiModelProperty(name = "id", notes = "索引id")
    private int id;

    @NotBlank
    @ApiModelProperty(name = "name", notes = "名字")
    private String name;

    @ApiModelProperty(name = "age", notes = "年龄")
    private int age;

    @ApiModelProperty(name = "address", notes = "地址")
    private String address;

    @ApiModelProperty(name = "salary", notes = "收入")
    private double salary;
}
