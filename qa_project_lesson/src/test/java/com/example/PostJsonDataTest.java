package com.example;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostJsonDataTest {

     @Test
    public void testPostJsonData() {

        given()
            .contentType("application/json")
            .body("{\"data\": \"This is expected to be sent back as part of response body\"}")
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("json.data", equalTo("This is expected to be sent back as part of response body"));
    }
    
}
