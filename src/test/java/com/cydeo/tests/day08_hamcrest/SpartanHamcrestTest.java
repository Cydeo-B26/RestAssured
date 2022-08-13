package com.cydeo.tests.day08_hamcrest;

import com.cydeo.utils.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanHamcrestTest extends SpartanTestBase {
    /**
     given accept type is json
     and path id is 24
     When i send get request to /spartans/{id}
     then status code is 200
     and content type is application/json
     and id" is 24,
     "name" is "Julio",
     "gender" is "Male",
     "phone" is 9393139934
     */
    @DisplayName("GET /spartans/{id} -> hamcrest assertions")
    @Test
    public void singleSpartanTest() {
        given().accept(ContentType.JSON)
                .and().pathParam("id", 24)
                .when().get("/spartans/{id}")
                .then().statusCode(is(200))
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("id", is(24) ,
                                "name" , equalTo("Julio"),
                                "gender", is("Male"),
                                "phone" , is(9393139934L));

    }


}
