package com.example.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Region implements EntityInterface {

    private Long id;
    private String name;
    private String code;

}
