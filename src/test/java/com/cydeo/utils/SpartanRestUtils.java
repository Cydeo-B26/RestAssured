package com.cydeo.utils;
import com.cydeo.pojo.Spartan;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;

public class SpartanRestUtils {

    private static String baseUrl = ConfigurationReader.getProperty("spartan.api.url");

    public static void deleteSpartanById(int spartanID) {
        System.out.println("DELETE spartan with id {" + spartanID +"}");
        //send DELETE request {{baseUrl}}/api/spartans/{id}
        given().pathParam("id", spartanID)
                .when().delete(baseUrl +"/spartans/{id}")
                .then().log().all();
    }

    public static Spartan getNewSpartan() {
        Faker random = new Faker();
        Spartan spartan = new Spartan();
        spartan.setName(random.name().firstName());

        int num = random.number().numberBetween(1,3);
        if (num == 1) {
            spartan.setGender("Female");
        } else {
            spartan.setGender("Male");
        }
        spartan.setPhone(random.number().numberBetween(1000000000L, 9999999999L));

        return spartan;
    }

}
