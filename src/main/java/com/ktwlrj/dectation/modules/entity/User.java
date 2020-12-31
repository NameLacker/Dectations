package com.ktwlrj.dectation.modules.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private long id;
    private String email;
    private String password;
    private String name;
    private long createAt;
}
