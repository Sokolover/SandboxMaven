package com.src.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Deduction {

    private static final String deadCatJson = a2q("{'name':'Felix','causeOfDeath':'entropy'}");
    private static final String liveCatJson = a2q("{'name':'Felix','angry':true}");

    private static final ObjectMapper JSON_MAPPER = newJsonMapper();

    public static void main(String[] args) throws Exception {
        Cat cat = JSON_MAPPER.readValue(liveCatJson, Cat.class);
        LiveCat catLive = (LiveCat) JSON_MAPPER.readValue(liveCatJson, Cat.class);
        DeadCat catDead = (DeadCat) JSON_MAPPER.readValue(deadCatJson, Cat.class);

        System.out.println();
    }

    protected static ObjectMapper newJsonMapper() {
        return new ObjectMapper();
    }

    protected static String a2q(String json) {
        return json.replace("'", "\"");
    }
}
