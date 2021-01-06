package com.ktwlrj.dectation.modules.service.dto;

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
    private List<T> classes;

    private BigInteger number;

    public CountDto(List<T> allUser, BigInteger number) {
        this.classes = allUser;
        this.number = number;
    }
}
