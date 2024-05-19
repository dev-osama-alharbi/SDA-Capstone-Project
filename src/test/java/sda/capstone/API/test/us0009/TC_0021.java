package sda.capstone.API.test.us0009;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.UserGroupType;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0021 extends ApiBase {
    private UserGroupType UserGroupMain  = UserGroupType
            .builder()
            .id(null)
            .name("dep")
            .description("Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc.\"\n" +
                    "    }")
            .build();
    @Test
    public void addUserGroupType() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(UserGroupMain)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();
        UserGroupType userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupType.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 201 ,"Status code must be 201");
        Assert.assertTrue(userStatusResponse.getId() != 0,"User Status id must not 0");
        Assert.assertTrue(userStatusResponse.getName().equals(UserGroupMain.getName()),"Check the Name = 'dep'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(UserGroupMain.getDescription()),"Check the description = 'Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc.\"\n" +
                "    }");

        APIVars.UserGroupType = userStatusResponse.getId();
    }

    @Test(dependsOnMethods = "addUserGroupType")
    public void getUserStatusByIdAndVerifyAddedTest() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group");
        pathParams.put("id", APIVars.UserGroupType+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId() == APIVars.UserGroupType,"User Group Type id must equal "+ APIVars.UserGroupType);
        Assert.assertTrue(userStatusResponse.getName().equals(UserGroupMain.getName()),"Check the Name = 'dep'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(UserGroupMain.getDescription()),"Check it have description");
    }
}
