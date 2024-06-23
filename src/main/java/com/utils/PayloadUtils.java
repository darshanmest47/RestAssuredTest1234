package com.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class PayloadUtils {

    public static String getPostPayload1() {
        return "{\n" +
                "    \"title\": \"test product one\",\n" +
                "    \"price\": 11.5,\n" +
                "    \"description\": \"this is a test product\",\n" +
                "    \"image\": \"https://i.pravatar.cc\",\n" +
                "    \"category\": \"electronic\"\n" +
                "}";
    }


    public static String getPostPayload2() {
        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(FWConstants.postPayloadPath)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return string;
    }

}
