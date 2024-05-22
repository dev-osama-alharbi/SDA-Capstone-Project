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

public class TC0046 extends ApiWithCookieHeaderBase {
    @Test
    public void getOrganizationByIdTest(){
        String strOrgId = String.valueOf(APIVars.read().getOrganizationId());
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "v1");
        pathParams.put("second", "organization");
        pathParams.put("third", "summary");
        pathParams.put("org_id", strOrgId);

        spec.pathParams(pathParams);
        Response response = RestAssured.given(spec)
                .get("/a3m/auth/api/{first}/{second}/{org_id}/{third}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403 ,"Status code must be 403 Forbidden");
        Assert.assertTrue(response.body().asString().contains("Forbidden"));
    }
}
