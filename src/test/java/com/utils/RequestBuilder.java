package com.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    public static Response getRequest() {
        return given().contentType(ContentType.JSON)
                .baseUri(PropertyUtils.getValue("baseURI"))
                .get(PATHS.PRODUCTS.getUrl());
    }


}
