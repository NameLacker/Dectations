package com.ktwlrj.dectation.modules.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;


@Getter
@Setter
@ToString
@Accessors
public class CountDto<T> implements Serializable {

    @ApiModelProperty(name = "classes", notes = "输出列表")
    private List<T> classes;

    @ApiModelProperty(name = "number", notes = "输出总数")
    private BigInteger number;

    public CountDto(List<T> allUser, BigInteger number) {
        this.classes = allUser;
        this.number = number;
    }
}
