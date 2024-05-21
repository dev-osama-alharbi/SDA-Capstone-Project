package sda.capstone.API.test.us0005;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.Organization;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0042 extends ApiWithCookieHeaderBase {

    @Test
    public void getAllOrganizationsTest() {
        HashMap<String, String> pathParams = new HashMap<>();
        HashMap<String, String> queryParams = new HashMap<>();
        pathParams.put("first", "organization");
        queryParams.put("content", "full");

        spec.pathParams(pathParams).queryParams(queryParams);


        Response response = given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 404, "Status code should be 404");
        Assert.assertTrue(response.body().asString().isEmpty(), "Response body should be empty");
    }

}
