package sda.capstone.API.test.us0009;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserGroupTpye;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0021 extends ApiWithCookieHeaderBase {
    private UserGroupTpye UserGroupMain = UserGroupTpye
            .builder()
            .id(null)
            .name("Remote unit")
            .description("Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc.")
            .build();
    @Test
    public void addUserGroupType() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(UserGroupMain)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();
        UserGroupTpye userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupTpye.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 201 ,"Status code must be 201");
        Assert.assertTrue(userStatusResponse.getId() != 0,"User Status id must not 0");
        Assert.assertTrue(userStatusResponse.getName().equals(UserGroupMain.getName()),"Check the Name = 'Remote unit'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(UserGroupMain.getDescription()),"Check the description = 'Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc.");

        APIVars.writeUserStatusId(userStatusResponse.getId());
    }

    @Test(dependsOnMethods = "addUserGroupType")
    public void getUserGroupType() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");
        pathParams.put("id", APIVars.read().getUserStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        UserGroupTpye userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupTpye.class);
        int statusCode = response.statusCode();
        System.out.println("userStatusResponse.getId() = "+userStatusResponse.getId() +" && APIVars.userStatusId = "+APIVars.read().getUserStatusId());
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId().equals(APIVars.read().getUserStatusId()) ,"User Status id must equal "+ APIVars.read().getUserStatusId());
        Assert.assertTrue(userStatusResponse.getName().equals(UserGroupMain.getName()),"Check the Name = 'Department'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(UserGroupMain.getDescription()),"Check it have description");
    }
}

