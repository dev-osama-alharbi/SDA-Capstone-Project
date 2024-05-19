package sda.capstone.API.test.us0009;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0023 extends ApiWithCookieHeaderBase {
    @Test
    public void deleteUserGroupType() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");
        pathParams.put("id", APIVars.read().getUserStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .delete("/a3m/auth/api/{first}/{id}");
        response.prettyPrint();
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
    }

    @Test(dependsOnMethods = "deleteUserGroupType")
    public void getUserGroupType() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");
        pathParams.put("id", APIVars.read().getUserStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 404 ,"Status code must be 404");
    }
}

