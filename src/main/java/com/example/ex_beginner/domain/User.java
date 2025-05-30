package com.example.ex_beginner.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private Integer age;
    private String comment;
}
