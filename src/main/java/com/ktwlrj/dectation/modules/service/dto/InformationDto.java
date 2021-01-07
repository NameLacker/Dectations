package com.ktwlrj.dectation.modules.service.dto;


import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@Accessors
@AllArgsConstructor
public class InformationDto {

    @NonNull
    private int id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @NonNull
    private String gender;

    @NonNull
    private int score;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private BigInteger createAt;
}
