package sda.capstone.API.test.us0005;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.OrganizationService;
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
        pathParams.put("first","application");
        pathParams.put("sub_app","2");
        pathParams.put("second","organization");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}/{sub_app}/{second}");
        response.prettyPrint();

        OrganizationService[] organizationByAppArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationService[].class);
        List<OrganizationService> organizationByAppListResponse = new ArrayList<>(Arrays.asList(organizationByAppArraysResponse));


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!organizationByAppListResponse.isEmpty());
    }
}
