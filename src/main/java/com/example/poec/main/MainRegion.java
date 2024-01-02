package com.example.poec.main;

import com.example.poec.entity.Region;
import com.example.poec.repository.RegionRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainRegion {

    public static void main(String[] args){
        RegionRepository regionRepository = RegionRepository.getInstance();
        Region idf = regionRepository.findOneBy("name","Île-de-France");
        System.out.println("Population en IDF : "+regionRepository.findPopulationByRegion(idf));
        regionRepository.findCitiesByRegion(idf).forEach(System.out::println);
    }

}
