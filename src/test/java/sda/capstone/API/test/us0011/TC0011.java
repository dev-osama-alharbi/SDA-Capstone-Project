package sda.capstone.API.test.us0011;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.APIVars;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0011 extends ApiBase {

    @Test
    public void editUserStatusTest() {
        UserStatus userStatusUpdatedMain = UserStatus
                .builder()
                .id(APIVars.read().getUserStatusId())
                .name("Active")
                .description("Test User Status After Update")
                .build();

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(userStatusUpdatedMain)
                .put("/a3m/auth/api/{first}");
        response.prettyPrint();
        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId().equals(userStatusUpdatedMain.getId()),"User Status id must equal "+userStatusUpdatedMain.getId());
        Assert.assertTrue(userStatusResponse.getName().equals(userStatusUpdatedMain.getName()),"Check the Name = 'Active'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userStatusUpdatedMain.getDescription()),"Check the description = 'Test User Status After Update");

    }

    @Test(dependsOnMethods = "editUserStatusTest")
    public void getUserStatusByIdAndVerifyEditedTest() {
        UserStatus userStatusUpdatedMain = UserStatus
                .builder()
                .id(APIVars.read().getUserStatusId())
                .name("Active")
                .description("Test User Status After Update")
                .build();

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");
        pathParams.put("id", APIVars.read().getUserStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId().equals(APIVars.read().getUserStatusId()) ,"User Status id must equal "+ APIVars.read().getUserStatusId());
        Assert.assertTrue(userStatusResponse.getName().equals(userStatusUpdatedMain.getName()),"Check the Name = 'Active'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userStatusUpdatedMain.getDescription()),"Check the description is equal to 'Test User Status After Update'");
    }
}
