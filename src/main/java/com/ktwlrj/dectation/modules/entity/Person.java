package com.ktwlrj.dectation.modules.entity;

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

    @NonNull
    private BigInteger id;

    @NonNull
    private String name;

    @NonNull
    private String gender;

    @NonNull
    private Double tall;

    @NonNull
    private Double weights;
}
