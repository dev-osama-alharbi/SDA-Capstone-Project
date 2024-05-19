package sda.capstone.API.test.us0003;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllMemberships;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0025 extends ApiWithCookieHeaderBase {

    @Test
    public void GetAllMemberships() {
        HashMap<String, String> pathParams = new HashMap<>();
        HashMap<String, String> queryParams = new HashMap<>();
//        pathParams.put("first", "v1");
//        queryParams.put("second", "membership");
        //{{base_url}}/auth/api/v1/membership

        spec.pathParams(pathParams).queryParams(queryParams);


        Response response = given(spec).get("/a3m/auth/api/v1/membership");
        response.prettyPrint();


        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200, "Status code should be 200");
    }

}