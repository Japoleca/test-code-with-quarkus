package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class MyUtilsControllerTest {

    @Test
    public void testPrimeIsTrue() throws Exception{
        given()
                .when().get("/util/validate/prime/3")
                .then()
                .statusCode(200)
                .body(is("true"));
    }

    @Test
    public void testPrimeIsFalse() throws Exception{
        given()
                .when().get("/util/validate/prime/1")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

    @Test
    public void testVerifyTextSize() throws Exception{
        given()
        .when().get("/util/count/testing")
                .then()
                .statusCode(200)
                .body(is("7"));
    }
}
