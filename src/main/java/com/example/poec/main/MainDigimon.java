package com.example.poec.main;

import com.example.poec.service.DigimonApiService;

public class MainDigimon {

    public static void main(String[] args) {
        DigimonApiService digimonApiService = new DigimonApiService();
        digimonApiService.getDigimons().forEach(System.out::println);
    }

}
