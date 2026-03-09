package com.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Test
public class DeleteTest extends BaseTest {

    @Test
    public void testDeleteRequest() {
        given()
            .queryParam("itemId", "123")
        .when()
            .delete("/delete")
        .then()
            .statusCode(200)
            .body("args.itemId", equalTo("123"));
    }
}

