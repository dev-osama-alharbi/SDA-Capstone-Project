package sda.capstone.API.test.us0009;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserGroupTpye;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0022 extends ApiWithCookieHeaderBase {
    @Test
    public void editUserGroupType() {
        UserGroupTpye userGroupTypeUpdatedMain = UserGroupTpye
                .builder()
                .id(APIVars.read().getUserStatusId())
                .name("Remote unit")
                .description("Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc. After Update")
                .build();

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(userGroupTypeUpdatedMain)
                .put("/a3m/auth/api/{first}");
        response.prettyPrint();
        UserGroupTpye userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupTpye.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId().equals(userGroupTypeUpdatedMain.getId()),"User Status id must equal "+userGroupTypeUpdatedMain.getId());
        Assert.assertTrue(userStatusResponse.getName().equals(userGroupTypeUpdatedMain.getName()),"Check the Name = 'Remote unit'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userGroupTypeUpdatedMain.getDescription()),"Check the description = 'Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc. After Update");

    }

    @Test(dependsOnMethods = "editUserGroupType")
    public void getUserGroupType() {
        UserGroupTpye userGroupTypeUpdatedMain = UserGroupTpye
                .builder()
                .id(APIVars.read().getUserStatusId())
                .name("Remote unit")
                .description("Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc. After Update")
                .build();

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group-type");
        pathParams.put("id", APIVars.read().getUserStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        UserGroupTpye userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupTpye.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(userStatusResponse.getId().equals(APIVars.read().getUserStatusId()) ,"User Status id must equal "+ APIVars.read().getUserStatusId());
        Assert.assertTrue(userStatusResponse.getName().equals(userGroupTypeUpdatedMain.getName()),"Check the Name = 'Remote unit'");
        Assert.assertTrue(userStatusResponse.getDescription().equals(userGroupTypeUpdatedMain.getDescription()),"Check the description is equal to 'Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc. After Update'");
    }
}

