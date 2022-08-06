package com.cydeo.tests.day04_path_jsonpath;

import com.cydeo.utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.junit.jupiter.api.Assertions.*;


public class HRApiGetTest {

    @BeforeEach  //@Before in Junit 4
    public void setUp() {
                                //http://54.211.225.58:1000/ords/hr
        //RestAssured.baseURI = ConfigurationReader.getProperty("hr.api.url");
        baseURI = ConfigurationReader.getProperty("hr.api.url");
    }

    /**
     * Given accept type is json
     * When user send get request to /ords/hr/regions
     * Status code should be 200
     * Content type should be "application/json"
     * And body should contain "Europe"
     */
    @DisplayName("GET /regions")
    @Test
    public void getRegionsTest() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/regions");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.asString().contains("Europe") , "Europe is not in json body");
        //BREAK TILL 12:10 PM EST
    }

}














