package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetTests extends BaseTest {

    @Test
    public void testGetRequest() {
        given()
            .queryParam("foo1", "bar1")
            .queryParam("foo2", "bar2")
        .when()
            .get("/get")
        .then()
            .statusCode(200)
            .body("args.foo1", equalTo("bar1"))
            .body("args.foo2", equalTo("bar2"));
    }
}

