package com.utils;

import java.io.FileInputStream;
import java.util.*;

public final class PropertyUtils {
    private static Map<String, String> map = new HashMap<String, String>();

    static {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(FWConstants.propertiesPath);
            props.load(fis);
            props.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getValue(String key) {
        return map.get(key);
    }
}
