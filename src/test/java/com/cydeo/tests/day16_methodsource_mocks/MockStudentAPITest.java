package com.cydeo.tests.day16_methodsource_mocks;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class MockStudentAPITest {

    @BeforeAll
    public static void setUp(){
        baseURI = "https://457874f4-e103-4a5f-80ea-d5af02231ed7.mock.pstmn.io";
    }
    @DisplayName("GET /students/1")
    @Test
    public void testStudent() {
        given().accept(ContentType.JSON)
                .when().get("/students/1")
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .log().all();
    }

}
