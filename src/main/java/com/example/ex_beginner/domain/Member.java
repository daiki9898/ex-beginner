package com.example.ex_beginner.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private Integer id;
    private String name;
    private Integer age;
    private Integer depId;
}
