package com.example;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostFormDataTests extends BaseTest {

    @Test
    public void testPostFormData() {
        String jsonBody = "{\"data\": \"This is expected to be sent back as part of response body\"}";

        given()
            .contentType("application/json")
            .body(jsonBody)
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("json.data", equalTo("This is expected to be sent back as part of response body"));
    }
}

