package sda.capstone.API.test.us0005;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.OrganizationService;
import sda.capstone.API.pojo.UserStatus;
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

        OrganizationService[] allOrganizationArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationService[].class);
        List<OrganizationService> allOrganizationListResponse = new ArrayList<>(Arrays.asList(allOrganizationArraysResponse));
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200, "Status code should be 200");
        Assert.assertTrue(!allOrganizationListResponse.isEmpty(), "Response body should not be empty");
    }

}
