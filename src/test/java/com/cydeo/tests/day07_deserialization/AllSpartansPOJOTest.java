package com.cydeo.tests.day07_deserialization;

import com.cydeo.pojo.Spartan;
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

public class AllSpartansPOJOTest extends SpartanTestBase {
    /**
     Given accept type is json
     when I send GET request to /spartans
     Then status code is 200
     And content type is json
     And I can convert json to list of spartan pojos
     */
    @Test
    public void allSpartansToPojoTest() {
       Response response = given().accept(ContentType.JSON)
                .when().get("/spartans");
       assertEquals(200, response.statusCode());
       assertEquals("application/json", response.contentType());

       //convert response to jsonpath
        JsonPath jsonPath = response.jsonPath();

        //using jsonPath extract List of spartans/ do deserialization
        List<Spartan> allSpartans = jsonPath.getList("",Spartan.class);

        System.out.println("count = " + allSpartans.size());

        //first spartan
        System.out.println("first spartan = " + allSpartans.get(0));
        
        //using streams: filter and store female spartans into a different list
        List<Spartan> femaleSpartans = allSpartans.stream()
                                        .filter(spartan -> spartan.getGender().equals("Female"))
                                        .collect(Collectors.toList());

        System.out.println("femaleSpartans = " + femaleSpartans);
        System.out.println("femaleSpartans.size() = " + femaleSpartans.size());

        //using streams: filter and store male spartans into a different list
        //source.stream.filter(condition in lambda).collect(type)
        long count = allSpartans.stream().filter(sp -> sp.getGender().equals("Male")).count();
        System.out.println("male spartan count = " + count);
        List<Spartan> maleSpartans = allSpartans.stream().filter(sp -> sp.getGender().equals("Male"))
                .collect(Collectors.toList());
        System.out.println("maleSpartans = " + maleSpartans);


    }




}








