package com.example.ex_beginner.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserForm {
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    @NotBlank
    private String comment;
}
