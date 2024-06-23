package com.utils;

public enum PATHS {
    PRODUCTS("/products");

    private String url;


    PATHS(String s) {
        this.url = s;
    }

    public String getUrl(){
        return url;
    }
}
