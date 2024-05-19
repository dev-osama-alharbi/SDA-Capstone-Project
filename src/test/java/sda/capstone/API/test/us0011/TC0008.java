package sda.capstone.API.test.us0011;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TC0008 extends ApiBase {

    @Test
    public void getAllUserStatusAndVerifyTest() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();
        System.out.println("response.statusCode() => "+response.statusCode());
//        List<UserStatus> userStatusListResponse = new ArrayList<>(Arrays.asList(response.as(UserStatus[].class)));
        UserStatus[] userStatusArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus[].class);
        List<UserStatus> userStatusListResponse = new ArrayList<>(Arrays.asList(userStatusArraysResponse));
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!userStatusListResponse.isEmpty(),"User Status List must not empty");
    }
}