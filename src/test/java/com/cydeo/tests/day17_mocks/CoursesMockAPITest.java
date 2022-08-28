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
}
