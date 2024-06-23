package com.tests;


import com.utils.RequestBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public class APITests {

    @Test(priority =0)
    public void getTest(){
        Response response = RequestBuilder.getRequest();
        response.prettyPrint();
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("results.json"));
        assertThat(response.statusCode()).isNotZero()
                .isEqualTo(200);
    }
}
