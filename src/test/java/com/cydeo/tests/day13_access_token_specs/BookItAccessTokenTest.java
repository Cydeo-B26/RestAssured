package com.cydeo.tests.day13_access_token_specs;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.DisplayName;
import io.restassured.response.Response;

public class BookItAccessTokenTest {
    /**
    Given accept type is Json
    And Query params: email = blyst6@si.edu & password = barbabaslyst
    When I send GET request to
    Url: https://cybertek-reservation-api-qa3.herokuapp.com/sign
    Then status code is 200
    And accessToken should be present and not empty
     */

    @Test
    public void bookItLoginTest() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("email", "blyst6@si.edu")
                .and().queryParam("password","barbabaslyst")
                .when().get("https://cybertek-reservation-api-qa3.herokuapp.com/sign");

        response.prettyPrint();
        System.out.println("status code = " + response.statusCode());
        Assertions.assertEquals(200, response.statusCode());



    }


}
