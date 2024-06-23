package com.tests;


import com.utils.CommonUtils;
import com.utils.PATHS;
import com.utils.RequestBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public class APITests {

    @Test(priority =0)
    public void getTest(){
        Response response = RequestBuilder.getRequest().get(PATHS.PRODUCTS.getUrl());;
        response.prettyPrint();
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("results.json"));
        assertThat(response.statusCode()).isNotZero()
                .isEqualTo(200);
    }

    @Test(priority = 1)
    public void postTest1(){
        String requestPayload = CommonUtils.getPostPayload1();
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        String title = response.jsonPath().get("title");
        assertThat(title).isEqualTo("test product one");
    }
}
