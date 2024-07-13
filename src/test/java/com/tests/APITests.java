package com.tests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.frameworkanntations.FrameWorkAnnotations;
import com.pojos.ExternalBuilder;
import com.utils.ObjectMapperUtility;
import com.utils.PayloadUtils;
import com.utils.PATHS;
import com.utils.RequestBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.*;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.pojos.*;

public class APITests {

    @Test(priority = 0, description = "test using get method")
    @FrameWorkAnnotations(authors = {"Suraj Mesta"}, catgeories = {"regression"})
    public void getTest() {
        Response response = RequestBuilder.getRequest().get(PATHS.PRODUCTS.getUrl());
        ;
        response.prettyPrint();
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("results.json"));
        assertThat(response.statusCode()).isNotZero().isEqualTo(200);
        Reporter.log(response.asPrettyString());
    }

    @Test(priority = 1, description = "test using post method")
    @FrameWorkAnnotations(authors = {"Suraj Mesta"}, catgeories = {"regression"})
    public void postTest1() {
        String requestPayload = PayloadUtils.getPostPayload1();
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        String title = response.jsonPath().get("title");
        assertThat(title).isEqualTo("test product one");
        Reporter.log(response.asPrettyString());

    }

    @Test(priority = 2, description = "test using external file")
    @FrameWorkAnnotations(authors = {"Suraj Mesta"}, catgeories = {"regression"})
    public void postTestFromExternalFile() {
        String requestPayload = PayloadUtils.getPostPayload2();
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        Reporter.log(response.asPrettyString());

    }

    @Test(priority = 3, description = "test using replacing from external file")
    @FrameWorkAnnotations(authors = {"Suraj Mesta"}, catgeories = {"regression"})
    public void postTestFromExtAndReplacing() {
        String requestPayload = PayloadUtils.getPostPayload2().replace("test product one", "test product two");
        System.out.println("the request payload after replacing is " + requestPayload);
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        String title = response.jsonPath().get("title");
        assertThat(title).isEqualTo("test product two");
        Reporter.log(response.asPrettyString());


    }

    @Test(priority = 4, description = "testing using external builder class")
    @FrameWorkAnnotations(authors = {"Darshan Mesta"}, catgeories = {"regression"})
    public void testUsingExternalBuilder() throws JsonProcessingException {
        MainBuilder payload = ExternalBuilder.build().with().setTitle("test product three").and().with().setPrice(13.8).and().with().setDescription("this is a test product three").and().with().setImage("https://i.pravatar.cc").and().with().setCategory("Electronics").perform();

        String requestPayload = ObjectMapperUtility.convertToString(payload);
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        String title = response.jsonPath().get("title");
        assertThat(title).contains("three");

        Reporter.log(response.asPrettyString());


    }

    @Test(priority = 5, description = "testing using static Inner class")
    @FrameWorkAnnotations(authors = {"Darshan Mesta"}, catgeories = {"regression"})
    public void testUsingStaticInnerClass() {
        StaticInnerBuilder payload = StaticInnerBuilder.StaticInnerClass.build().with().setTitle("test product four").and().with().setPrice(14.5).and().with().setDescription("this is a test product three").and().with().setImage("https://i.pravatar.cc").and().with().setCategory("Electronics").perform();

        String requestPayload = ObjectMapperUtility.convertToString(payload);
        Response response = RequestBuilder.postRequest().body(requestPayload).post(PATHS.PRODUCTS.getUrl());
        response.prettyPrint();
        assertThat(response.statusCode()).isEqualTo(200);
        String title = response.jsonPath().get("title");
        assertThat(title).contains("four");

        Reporter.log(response.asPrettyString());


    }
}
