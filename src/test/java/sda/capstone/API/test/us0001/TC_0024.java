package sda.capstone.API.test.us0001;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllAuth;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TC_0024 extends ApiWithCookieHeaderBase {
    @Test
    public void GetAll0Auth() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","userinfo");



        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/{first}");
        response.prettyPrint();
        System.out.println("response.statusCode() => "+response.statusCode());
//        List<UserStatus> userStatusListResponse = new ArrayList<>(Arrays.asList(response.as(UserStatus[].class)));
        AllAuth[] userStatusArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),AllAuth[].class);
        List<AllAuth> userStatusListResponse = new ArrayList<>(Arrays.asList(userStatusArraysResponse));
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!userStatusListResponse.isEmpty(),"User Status List must not empty");
    }
}

