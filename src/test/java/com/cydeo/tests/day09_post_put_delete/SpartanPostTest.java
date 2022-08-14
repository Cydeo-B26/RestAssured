package com.cydeo.tests.day09_post_put_delete;

import com.cydeo.utils.SpartanTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanPostTest extends SpartanTestBase {

    /**
     given accept is json and content type is json
     and body is:
     {
     "gender": "Male",
     "name": "TestPost1"
     "phone": 1234567425
     }
     When I send POST request to /spartans
     Then status code is 201
     And content type is json
     And "success" is "A Spartan is Born!"
     Data name, gender , phone matches my request details
     */

    @DisplayName("POST new spartan using string json")
    @Test
    public void addNewSpartanAsJsonTest() {
        String jsonBody = "{\n" +
                "     \"gender\": \"Male\",\n" +
                "     \"name\": \"TestPost1\",\n" +
                "     \"phone\": 1234567425\n" +
                "     }";

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(jsonBody)
                .when().post("/spartans");

        response.prettyPrint();
        System.out.println("status code = " + response.statusCode());
        assertThat(response.statusCode(), is(201));

        //verify header
        assertThat(response.contentType(), is("application/json"));

        //assign response to jsonpath
        JsonPath jsonPath = response.jsonPath();
        assertThat(jsonPath.getString("success"), equalTo("A Spartan is Born!"));
        assertThat(jsonPath.getString("data.name"), equalTo("TestPost1"));

        assertThat(jsonPath.getString("data.gender"), equalTo("Male"));
        assertThat(jsonPath.getLong("data.phone"), equalTo(1234567425L));

        //delete the spartan after post
    }

}
