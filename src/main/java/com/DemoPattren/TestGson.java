package com.DemoPattren;

import com.google.gson.Gson;

import java.util.HashMap;

public class TestGson {
    public static String createNullPlayLoad(){
        String payload = new HashMap<String,Object>().toString();

        return payload;
    }

    public static void main(String[] args) {
        System.out.println(createNullPlayLoad());
    }

}
