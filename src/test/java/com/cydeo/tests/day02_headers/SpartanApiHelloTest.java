package com.cydeo.tests.day02_headers;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 When I send GET request to http://3.93.242.50:8000/api/hello
 Then status code should be 200
 And response body should be equal to "Hello from Sparta"
 And content type is "text/plain;charset=UTF-8"
 */

public class SpartanApiHelloTest {
    String url = "http://3.93.242.50:8000/api/hello";

    @DisplayName("GET api/hello")
    @Test
    public void helloApiTest() {
        Response response = when().get(url);

        System.out.println("status code = " + response.statusCode());
        assertEquals(200, response.statusCode());

        response.prettyPrint();
        assertEquals("Hello from Sparta", response.body().asString());

        System.out.println("Content type = " + response.contentType());
        assertEquals("text/plain;charset=UTF-8",response.contentType() );
    }

    /**
     *
     When I send GET request to http://3.93.242.50:8000/api/hello
     Then status code should be 200
     And content type is "text/plain;charset=UTF-8"
     BDD -> given, when, then, and keywords. making readable
     */

    @DisplayName("GET api/hello - bdd")
    @Test
    public void helloApiBddTest() {
        when().get(url)
        .then().assertThat().statusCode(200)
        .and().contentType("text/plain;charset=UTF-8");
    }

}
