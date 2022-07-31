package com.cydeo.tests.day01_intro;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * When User sends GET Request to
 * https://reqres.in/api/users
 *
 * Then Response status code should be 200
 * And Response body should contain "George"
 * And Header Content type should be json
 */

public class RecResApiTest {

    String url = "https://reqres.in/api/users";

    @DisplayName("GET all users")
    @Test
    public void usersGetTest() {
        //When User sends GET Request
      Response response = when().get(url);
      //Response response = RestAssured.get(url); both same. first one more readable

      //Then Response status code should be 200
      System.out.println("status code = " + response.statusCode());
      assertEquals(200, response.statusCode());

      //BDD syntax
      response.then().statusCode(200);
      response.then().assertThat().statusCode(200);

      //And Response body should contain "George"
      System.out.println("Response json body = " + response.asString());
      assertTrue(response.asString().contains("George"));

      //And Header Content type should be application/json
        System.out.println("Content type header value = " + response.contentType());
        assertTrue(response.contentType().contains("application/json"));
    }

//    When User Sends get request to API Endpoint:
//            "https://reqres.in/api/users/5"
//    Then Response status code should be 200
//    And Response body should contain user info "Charles"

    @Test
    public void getSingleUserApiTest() {

    }

}
