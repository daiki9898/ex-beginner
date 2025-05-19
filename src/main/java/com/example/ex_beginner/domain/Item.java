package com.example.ex_beginner.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private String name;
    private Integer price;
}
