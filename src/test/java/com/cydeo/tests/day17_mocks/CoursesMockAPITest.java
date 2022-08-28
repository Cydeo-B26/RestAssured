package com.cydeo.tests.day17_mocks;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CoursesMockAPITest {
    @BeforeAll
    public static void setUp(){
        baseURI = "https://457874f4-e103-4a5f-80ea-d5af02231ed7.mock.pstmn.io";
    }

    /**
     Given accept type is json
     When I send get request to /courses
     Then status code is 200
     And content type is json
     And body courseIds contain 1,2,3
     And courseNames are "Java SDET", "Java Developer", "Cyber Security Analyst"
     */
    @Test
    public void coursesMockTest() {

    }

}
