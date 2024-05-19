package sda.capstone.API.test.us0009;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserGroupTpye;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0020 extends ApiWithCookieHeaderBase {
@Test
public void getUserGroupType() {
    HashMap<String,String> pathParams = new HashMap<>();
    pathParams.put("first","user-group-type");
    pathParams.put("id","1");

    spec.pathParams(pathParams);
    Response response = given(spec)
            .get("/a3m/auth/api/{first}/{id}");

    UserGroupTpye userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupTpye.class);

    int statusCode = response.statusCode();

    Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
    Assert.assertTrue(userStatusResponse.getId() == 1,"User Status List must not empty");
    Assert.assertTrue(userStatusResponse.getName().equals("Department"),"Check the Name = 'Department'");
    Assert.assertTrue(userStatusResponse.getDescription().contains("User account is deactivated, and not authorized to access any the application"),"Check it have description");
}
}
