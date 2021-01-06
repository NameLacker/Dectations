package com.ktwlrj.dectation.modules.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Accessors
public class Student implements Serializable {

    @NonNull
    private BigInteger id;

    @NonNull
    private String name;

    @NonNull
    private Integer score;

    @NonNull
    private Integer age;

    @NonNull
    private String gender;
}
