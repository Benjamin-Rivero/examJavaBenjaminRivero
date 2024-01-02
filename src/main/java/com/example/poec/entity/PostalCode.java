package com.example.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostalCode implements EntityInterface {
    private Long id;
    private String code;

    @Override
    public String toString() {
        return code;
    }
}
