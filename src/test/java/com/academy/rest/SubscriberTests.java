package com.academy.rest;

import com.academy.lesson04.Abonent;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
                .log().all()
                .get("/subscribers");

        int code = response.getStatusCode();
        String body = response.getBody().print();
        int size = response.getBody().path("size()");
        int id = response.getBody().path("[0].id");
        String fName = response.getBody().path("[0].firstName");
        String lastName = response.getBody().path("[0].lastName");

        Abonent abonent = new Abonent();
        abonent.setId(id);


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
                .log().all()
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

    @Test
    public void testAddSubscriber() {
        List<Abonent> before = getAllSubscribers();
//        String json = "{\"firstName\":\"Ivan3\",\"lastName\":\"Ivanov3\",\"age\":22,\"gender\":\"m\"}";
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("firstName", "Ivan4"); // Cast
        jsonObj.put("lastName", "Ivanov4");
        jsonObj.put("age", 68);
        jsonObj.put("gender", "m");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .post("/subscribers")
                .then()
                .assertThat()
                .header("Location", containsString("http://localhost:8081/rest/json/subscribers"))
                .statusCode(201);

        List<Abonent> after = getAllSubscribers();
        after.equals(before);
    }

    @Test
    public void testUpdateSubscriber() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", 6667);
        jsonObj.put("firstName", "Ivan_upd"); // Cast
        jsonObj.put("lastName", "Ivanov_upd");
        jsonObj.put("age", 68);
        jsonObj.put("gender", "m");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .put("/subscribers/6667")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testDeleteSubscriber() {
        given()
                .log().all()
                .delete("/subscribers/6667")
                .then()
                .assertThat()
                .statusCode(200);
    }

    private List<Abonent> getAllSubscribers() {
        return null;
    }
}
