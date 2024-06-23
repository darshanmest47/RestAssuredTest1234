package com.utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    public static RequestSpecification getRequest() {
        return given().contentType(ContentType.JSON)
                .baseUri(PropertyUtils.getValue("baseURI"));

    }

    public static RequestSpecification postRequest(){
        return given().contentType(ContentType.JSON)
                .baseUri(PropertyUtils.getValue("baseURI"));
    }


}
