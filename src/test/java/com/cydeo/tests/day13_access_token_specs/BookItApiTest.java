package com.cydeo.tests.day13_access_token_specs;

import com.cydeo.utils.BookItAPITestBase;
import com.cydeo.utils.ConfigurationReader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.DisplayName;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BookItApiTest extends BookItAPITestBase {
    /**
     Given accept type is json
     And header Authorization is access_token of teacher
     When I send GET request to /api/campuses
     Then status code is 200
     And content type is json
     And campus location info is presented in payload
     */
    @Test
    public void getAllCampusesTest() {
        String accessToken = getAccessToken(ConfigurationReader.getProperty("teacher_email"),
                ConfigurationReader.getProperty("teacher_password"));

        System.out.println("accessToken = " + accessToken);

        Response response = given().accept(ContentType.JSON)
                .and().header("Authorization", accessToken)
                .when().get("/api/campuses");

        response.prettyPrint();
        assertThat(response.statusCode(), is(200));
        assertThat(response.contentType(), is("application/json"));
        assertThat(response.path("location"), hasItems("VA", "IL"));
    }
}
