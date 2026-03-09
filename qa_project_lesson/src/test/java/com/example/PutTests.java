package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutTests extends BaseTest {

    @Test
    public void testPutJsonData() {
    
       given()
            .contentType("application/json")
            .body("{\"data\": \"This is expected to be sent back as part of response body\"}")
        .when()
            .put("/put")
        .then()
            .statusCode(200)
            .body("json.data", equalTo("This is expected to be sent back as part of response body"));
    }
}


