package com.cydeo.utils;
import static io.restassured.RestAssured.*;

public class SpartanRestUtils {

    private static String baseUrl = ConfigurationReader.getProperty("spartan.api.url");

    public static void deleteSpartanById(int spartanID) {
        //send DELETE request {{baseUrl}}/api/spartans/{id}
        given().pathParam("id", spartanID)
                .when().delete(baseUrl +"/{id}")
                .then().log().all();
    }

}
