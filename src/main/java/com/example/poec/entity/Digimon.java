package com.example.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Digimon {

    private String name;
    private String img;
    private String level;

    @Override
    public String toString() {
        return "Digimon{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
