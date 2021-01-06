package com.ktwlrj.dectation.modules.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Accessors
public class User implements Serializable {

    @NonNull
    private BigInteger id;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String name;

    @NonNull
    private long createAt;
}
