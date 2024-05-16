package sda.capstone.API.test.us0011;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.APIVars;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0048 extends ApiBase {

    @Test
    public void deleteUserStatusTest() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .delete("/a3m/auth/api/{first}/{id}");

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
    }

    @Test(dependsOnMethods = "deleteUserStatusTest")
    public void getUserStatusByIdAndVerifyIsDeletedTest() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");
        pathParams.put("id", APIVars.userStatusId+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 404 ,"Status code must be 404");
    }
}