package com.ktwlrj.dectation.modules.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class Person implements Serializable {

    @ApiModelProperty(name = "id", notes = "索引id")
    private BigInteger id;

    @ApiModelProperty(name = "name", value = "名字")
    private String name;

    @ApiModelProperty(name = "gender", value = "性别")
    private String gender;

    @ApiModelProperty(name = "tall", value = "身高")
    private Double tall;

    @ApiModelProperty(name = "weights", value = "体重")
    private Double weights;
}
