package sda.capstone.API.test.us0009;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserGroupTpye;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.path.xml.XmlPath.given;

public class TC_0019 extends ApiWithCookieHeaderBase {
    @Test
    public void GetAllUserGroupType() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");



        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();
        System.out.println("response.statusCode() => "+response.statusCode());
//        List<UserStatus> userStatusListResponse = new ArrayList<>(Arrays.asList(response.as(UserStatus[].class)));
        UserGroupTpye[] userStatusArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupTpye[].class);
        List<UserGroupTpye> userStatusListResponse = new ArrayList<>(Arrays.asList(userStatusArraysResponse));
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!userStatusListResponse.isEmpty(),"User Status List must not empty");
    }
}
