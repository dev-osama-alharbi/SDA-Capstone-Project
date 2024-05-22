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

public class TC0043 extends ApiWithCookieHeaderBase {
    @Test
    public void getOrganizationByApplicationIdTest(){
        HashMap<String,String> pathParams = new HashMap<>();
        String strApplicationId= String.valueOf(APIVars.read().getApplicationId());
        pathParams.put("first","application");
        pathParams.put("sub_app",strApplicationId);
        pathParams.put("second","organization");

        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/{first}/{sub_app}/{second}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 404 ,"Status code must be 404");
        Assert.assertTrue(response.body().asString().isEmpty());
    }
}
