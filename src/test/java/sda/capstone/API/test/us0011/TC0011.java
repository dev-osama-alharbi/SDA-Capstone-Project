package sda.capstone.API.test.us0011;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    private UserStatus userStatusUpdatedMain = UserStatus
            .builder()
            .id(APIVars.userStatusId)
            .name("Active")
            .description("Test User Status After Update")
            .build();
    @Test
    public void editUserStatusTest() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(userStatusUpdatedMain)
                .put("/a3m/auth/api/{first}");

        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId() == userStatusUpdatedMain.getId(),"User Status id must equal "+userStatusUpdatedMain.getId());
        Assert.assertTrue(userStatusResponse.getName().equals(userStatusUpdatedMain.getName()),"Check the Name = 'Active'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userStatusUpdatedMain.getDescription()),"Check the description = 'Test User Status After Update");

        APIVars.userStatusId = userStatusResponse.getId();
    }

    @Test(dependsOnMethods = "editUserStatusTest")
    public void getUserStatusByIdAndVerifyEditedTest() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");
        pathParams.put("id", APIVars.userStatusId+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId() == APIVars.userStatusId,"User Status id must equal "+ APIVars.userStatusId);
        Assert.assertTrue(userStatusResponse.getName().equals(userStatusUpdatedMain.getName()),"Check the Name = 'Active'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userStatusUpdatedMain.getDescription()),"Check the description is equal to 'Test User Status After Update'");
    }
}
