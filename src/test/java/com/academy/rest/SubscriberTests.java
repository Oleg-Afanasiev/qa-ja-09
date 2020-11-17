package com.academy.rest;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class SubscriberTests {

    private static final Logger LOG = LogManager.getLogger(SubscriberTests.class);

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost/rest/json";
        RestAssured.port = 8081;

        RestAssured.config = config()
                .logConfig(new LogConfig()
                        .defaultStream(IoBuilder.forLogger(LOG).buildPrintStream()));
    }

    @Test
    public void testGetSubscribers() {
        Response response = RestAssured.given()
                .get("/subscribers");

        int code = response.getStatusCode();
        String body = response.getBody().print();
        int size = response.getBody().path("size()");
        int id = response.getBody().path("[0].id");
        String fName = response.getBody().path("[0].firstName");
        String lastName = response.getBody().path("[0].lastName");


        System.out.println(code);
        System.out.println(body);
        System.out.println(size);
        System.out.println(id);
        System.out.println(fName);
        System.out.println(lastName);
    }

    @Test
    public void testGetAllSubscribers() {
        given()
                .when()
                .get("/subscribers")
                .then()
                .assertThat()
                .body("size()", greaterThanOrEqualTo(1))
                .and()
                .body("[0].id", equalTo(1))
                .and()
                .body("[0].firstName", equalTo("Peter"))
                .and()
                .statusCode(200);
    }
}
