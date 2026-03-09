package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Test
public class PatchTests extends BaseTest {

    @Test
    public void testPatchJsonData() {
        String jsonBody = "{\"partialUpdate\": \"This field was updated\"}";

        given()
            .contentType("application/json")
            .body(jsonBody)
        .when()
            .patch("/patch")
        .then()
            .statusCode(200)
            .body("json.partialUpdate", equalTo("This field was updated"));
    }
}

