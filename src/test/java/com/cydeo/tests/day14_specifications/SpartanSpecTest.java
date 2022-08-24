package com.cydeo.tests.day14_specifications;

import com.cydeo.utils.SpartanSecureTestBase;
import com.cydeo.utils.ConfigurationReader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


public class SpartanSpecTest extends SpartanSecureTestBase {


    @Test
    public void allSpartansTest() {

       given().accept(ContentType.JSON)
                .and().auth().basic("admin","admin")
                .when().get("/spartans")
               .then().log().all();



    }

}








