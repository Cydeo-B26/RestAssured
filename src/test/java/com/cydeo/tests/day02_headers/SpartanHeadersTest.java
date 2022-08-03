package com.cydeo.tests.day02_headers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanHeadersTest {
    String url = "http://54.211.225.58:8000/api/spartans";
    /**
     • When I send a GET request to
     • spartan_base_url/api/spartans
     • Then Response STATUS CODE must be 200
     • And I Should see all Spartans data in JSON format
     */
    @DisplayName("GET /api/spartans and expect Json response")
    @Test
    public void getAllSpartansHeaderTest() {
        when().get(url)         //request part
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON);
                //.and().contentType("application/json");
    }

    /**
     * Given Accept type is application/xml
     • When I send a GET request to
     -----------------------------
     • spartan_base_url/api/spartans
     • Then Response STATUS CODE must be 200
     • And I Should see all Spartans data in xml format
     */

}
