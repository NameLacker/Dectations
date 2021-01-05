package com.ktwlrj.dectation.modules.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class Developer implements Serializable {
    private int id = 1;
    private String name;
    private int age;
    private String address;
    private double salary;
}
