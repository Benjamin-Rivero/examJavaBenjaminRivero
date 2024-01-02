package com.example.poec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City implements EntityInterface {

    private Long id;
    private String siren;
    private int population;
    private String name;
    private List<PostalCode> postalCodes;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", siren='" + siren + '\'' +
                ", population=" + population +
                ", name='" + name + '\'' +
                ", postalCodes=" + postalCodes +
                '}';
    }
}
