package sda.capstone.API.test.us0005;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0047 extends ApiWithCookieHeaderBase {

    @Test
    public void deleteOrganizationByIdTest(){
        HashMap<String,String> pathParams = new HashMap<>();
        String strOrgId = String.valueOf(APIVars.read().getOrganizationId());
        pathParams.put("first","organization");
        pathParams.put("org_id",strOrgId);

        spec.pathParams(pathParams);
        Response response = given(spec).delete("/a3m/auth/api/{first}/{org_id}");


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(response.body().asString().isEmpty(), "Delete response body should be empty");
    }
}


