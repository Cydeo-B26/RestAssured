package com.cydeo.tests.day07_deserialization;


import com.cydeo.pojo.Spartan;
import com.cydeo.pojo.SpartanSearch;
import com.cydeo.utils.SpartanTestBase;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanSearchPOJOTest extends SpartanTestBase {

    /**
     Given accept type is json
     And query param nameContains value is "e"
     And query param gender value is "Female"
     When I send get request to /spartans/search
     Then status code is 200
     And content type is Json
     And json response data is as expected
     */
    @Test
    public void spartanSearchToPOJOTest() {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("nameContains","e");
        queryMap.put("gender","Female");

        Response response = given().accept(ContentType.JSON)
                .and().queryParams(queryMap)
                .when().get("/spartans/search");
        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals(ContentType.JSON.toString(), response.contentType());

        //deserialize json to SpartanSearch pojo class
        SpartanSearch spartanSearch = response.body().as(SpartanSearch.class);

        //total elements
        System.out.println("total Element = " + spartanSearch.getTotalElement());
        System.out.println("All spartans = " + spartanSearch.getContent());
        System.out.println("First spartan info = " + spartanSearch.getContent().get(0));



    }

}














