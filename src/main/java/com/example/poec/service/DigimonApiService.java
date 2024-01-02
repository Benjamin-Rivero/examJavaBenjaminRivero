package com.example.poec.service;

import com.example.poec.entity.Digimon;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class DigimonApiService {

    private HttpClientService httpClientService = new HttpClientService();

    public List<Digimon> getDigimons(){
        List<Digimon> digimons = new ArrayList<>();
        String url = "https://digimon-api.vercel.app/api/digimon";
        String json = httpClientService.get(url);
        if (json.isEmpty()) {
            return null;
        }

        JSONTokener tokener = new JSONTokener(json);
        JSONArray object = new JSONArray(tokener);

        for (int i = 0; i < object.length(); i++) {
            JSONObject character = object.getJSONObject(i);
            digimons.add(mapper(character));
        }
        //System.out.println(object);
        //return null;
        return digimons;
    }

    private Digimon mapper(JSONObject json){
        Digimon digimon = new Digimon();
        digimon.setName(json.getString("name"));
        digimon.setImg(json.getString("img"));
        digimon.setLevel(json.getString("level"));
        return digimon;
    }
}
