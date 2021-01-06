package com.ktwlrj.dectation.modules.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Accessors
public class Person implements Serializable {

    @NonNull
    private String name;

    @NonNull
    private String gender;

    @NonNull
    private Double tall;

    @NonNull
    private Double weights;
}
