package sda.capstone.API.test.us0011;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0010 extends ApiWithCookieHeaderBase {

    private UserStatus userStatusMain = UserStatus
            .builder()
            .id(null)
            .name("Active")
            .description("Test User Status")
            .build();
    @Test
    public void addUserStatusTest() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(userStatusMain)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();
        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 201 ,"Status code must be 201");
        Assert.assertTrue(userStatusResponse.getId() != 0,"User Status id must not 0");
        Assert.assertTrue(userStatusResponse.getName().equals(userStatusMain.getName()),"Check the Name = 'Active'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userStatusMain.getDescription()),"Check the description = 'Test User Status");

        APIVars.writeUserStatusId(userStatusResponse.getId());
    }

    @Test(dependsOnMethods = "addUserStatusTest")
    public void getUserStatusByIdAndVerifyAddedTest() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");
        pathParams.put("id", APIVars.read().getUserStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();
        System.out.println("userStatusResponse.getId() = "+userStatusResponse.getId() +" && APIVars.userStatusId = "+APIVars.read().getUserStatusId());
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId().equals(APIVars.read().getUserStatusId()) ,"User Status id must equal "+ APIVars.read().getUserStatusId());
        Assert.assertTrue(userStatusResponse.getName().equals(userStatusMain.getName()),"Check the Name = 'Active'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userStatusMain.getDescription()),"Check it have description");
    }
}
