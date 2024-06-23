package com.utils;


import lombok.Getter;

public final class FWConstants {

     static @Getter final String propertiesPath = System.getProperty("user.dir") + "/src/main/properties/config.properties";
     static @Getter final String postPayloadPath = System.getProperty("user.dir")+"/src/main/java/com/utils/postpayload.json";
}
