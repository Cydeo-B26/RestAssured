package com.cydeo.tests.day09_post_put_delete;

import com.cydeo.pojo.Spartan;
import com.cydeo.utils.SpartanRestUtils;
import com.cydeo.utils.SpartanTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanPostThenGET extends SpartanTestBase {
        //newSpartan object with random values
    Spartan newSpartan = SpartanRestUtils.getNewSpartan();

    @DisplayName("POST /spartan -> GET with id and compare")
    @Test
    public void postNewSpartanThenGETTest() {
        System.out.println("newSpartan = " + newSpartan);

    }
}
