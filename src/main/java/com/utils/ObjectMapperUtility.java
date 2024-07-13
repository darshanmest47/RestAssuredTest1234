package com.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtility {

    private ObjectMapperUtility(){}

    public static String convertToString(Object value){
        try{
        return String.valueOf(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(value));

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
