package com.ktwlrj.dectation.modules.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class User implements Serializable {
    private long id;
    private String email;
    private String password;
    private String name;
    private long createAt;
}
