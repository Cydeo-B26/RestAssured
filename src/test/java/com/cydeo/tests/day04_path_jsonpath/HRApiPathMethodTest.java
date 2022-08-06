package com.cydeo.tests.day04_path_jsonpath;

import com.cydeo.utils.HRApiTestBase;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HRApiPathMethodTest extends HRApiTestBase {

    @Test
    public void readCountriesUsingPathTest() {
        Response response = given().accept(ContentType.JSON)
                .when().get("countries");
        assertEquals(200, response.statusCode());

        System.out.println("first country id = " + response.path("items[0].country_id"));
        System.out.println("first country name = " + response.path("items[0].country_name"));

        assertEquals("AR" , response.path("items[0].country_id"));
        assertEquals("Argentina" , response.path("items[0].country_name"));

        //store all country names into a list
        List<String> countries = response.path("items.country_name");
        System.out.println("countries = " + countries);

    }

}
