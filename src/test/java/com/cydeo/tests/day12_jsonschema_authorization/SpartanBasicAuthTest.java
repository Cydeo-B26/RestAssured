package com.cydeo.tests.day12_jsonschema_authorization;

import com.cydeo.utils.SpartanSecureTestBase;
import com.cydeo.utils.SpartanTestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanBasicAuthTest extends SpartanSecureTestBase {
    /**
     given accept type is json
     and basic auth credentials are admin , admin
     When user sends GET request to /spartans
     Then status code is 200
     And content type is json
     And print response
     */
    @DisplayName("GET /spartans with basic auth")
    @Test
    public void getSpartansWithAuthTest() {
        given().accept(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .when().get("/spartans")
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().log().all();
    }

}
