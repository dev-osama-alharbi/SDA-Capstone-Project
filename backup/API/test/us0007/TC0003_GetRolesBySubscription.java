package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllRoles;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0003_GetRolesBySubscription extends ApiWithCookieHeaderBase {
    @Test
    public void GetAllRolesByOrganizationTest() {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("p1","role");
        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/{p1}");
        response.prettyPrint();

        AllRoles[] rolesBySubscriptionArrayResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), AllRoles[].class);
        List<AllRoles> rolesBySubscriptionListResponse = new ArrayList<>(Arrays.asList(rolesBySubscriptionArrayResponse));
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertFalse(rolesBySubscriptionListResponse.isEmpty(),"User Status List must not empty");

    }
}

