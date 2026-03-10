package com.echo.tests.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public static io.restassured.RestAssured.*;

public static org.hamcrest.Matchers.*;

public org.testng.annotations.*;

public java.util.HashMap;
import java.util.Map;

public com.echo.tests.utils.Constants;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
        RestAssured.basePath = "/";
    }
}

