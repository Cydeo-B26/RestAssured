package com.cydeo.tests.day10_db_vs_api_put_delete;
import com.cydeo.utils.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.cydeo.utils.SpartanRestUtils;
import com.cydeo.utils.SpartanTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanAPIAndDBValidationTest extends SpartanTestBase {

    /**
     given accept is json and content type is json
     and body is:
     {
     "gender": "Male",
     "name": "PostVSDatabase"
     "phone": 1234567425
     }
     When I send POST request to /spartans
     Then status code is 201
     And content type is json
     And "success" is "A Spartan is Born!"
     When I send database query
     SELECT name, gender, phone
     FROM spartans
     WHERE spartan_id = newIdFrom Post request;
     Then name, gender , phone values must match with POST request details
     */

    @DisplayName("POST /api/spartan -> then validate in DB")
    @Test
    public void postNewSpartanThenValidateInDBTest() {
        Map<String, Object> postRequestMap = new HashMap<>();
        postRequestMap.put("gender", "Male");
        postRequestMap.put("name", "PostVSDatabase");
        postRequestMap.put("phone", 1234567425L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(postRequestMap) //set request json body. map > json
                .when().post("/spartans");

        response.prettyPrint();

        assertThat(response.statusCode(), equalTo(201));
        assertThat(response.contentType(), equalTo("application/json"));

        JsonPath jsonPath = response.jsonPath();

        //assertThat(response.path("success"), equalTo("A Spartan is Born!"));
        //assertThat(response.jsonPath().getString("success"), equalTo("A Spartan is Born!"));
        assertThat(jsonPath.getString("success"), equalTo("A Spartan is Born!"));

        int newSpartanID = jsonPath.getInt("data.id");
        System.out.println("newSpartanID = " + newSpartanID);

        //database steps
        String query = "SELECT name, gender, phone FROM spartans WHERE spartan_id = " + newSpartanID;

        DBUtils.createConnection();
    }

}
