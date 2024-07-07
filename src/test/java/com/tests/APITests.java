package com.tests;


import com.utils.PayloadUtils;
import com.utils.PATHS;
import com.utils.RequestBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class APITests {

    @Test(priority =0,description = "test using get method")
    public void getTest(){
        Response response = RequestBuilder.getRequest().get(PATHS.PRODUCTS.getUrl());;
        response.prettyPrint();
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("results.json"));
        assertThat(response.statusCode()).isNotZero()
                .isEqualTo(200);
        Reporter.log(response.asPrettyString());
    }

    @Test(priority = 1,description = "test using post method")
    public void postTest1(){
        String requestPayload = PayloadUtils.getPostPayload1();
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        String title = response.jsonPath().get("title");
        assertThat(title).isEqualTo("test product one");
        Reporter.log(response.asPrettyString());

    }

    @Test(priority=2,description = "test using external file")
    public void postTestFromExternalFile(){
       String requestPayload = PayloadUtils.getPostPayload2();
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        Reporter.log(response.asPrettyString());

    }

    @Test(priority=3,description = "test using replacing from external file")
    public void postTestFromExtAndReplacing(){
        String requestPayload = PayloadUtils.getPostPayload2().replace("test product one","test product two");
        System.out.println("the request payload after replacing is "+requestPayload);
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        String title = response.jsonPath().get("title");
        assertThat(title).isEqualTo("test product two");
        Reporter.log(response.asPrettyString());



    }
}
