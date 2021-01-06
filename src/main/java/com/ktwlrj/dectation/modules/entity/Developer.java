package com.ktwlrj.dectation.modules.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Accessors
public class Developer implements Serializable {

    @NonNull
    private int id = 1;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @NonNull
    private String address;

    @NonNull
    private double salary;
}
