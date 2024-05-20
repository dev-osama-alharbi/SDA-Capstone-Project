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
        String strApplicationId= String.valueOf(APIVars.read().getApplicationId()); //TODO: Add in US0001 -> APIVars.writeApplicationId(userStatusArraysResponse.getSub_app());
        pathParams.put("first","application");
        pathParams.put("sub_app",strApplicationId);
        pathParams.put("second","organization");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}/{sub_app}/{second}");
        response.prettyPrint();

        Organization[] organizationByAppArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),Organization[].class);
        List<Organization> organizationByAppListResponse = new ArrayList<>(Arrays.asList(organizationByAppArraysResponse));


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!organizationByAppListResponse.isEmpty());
    }
}
