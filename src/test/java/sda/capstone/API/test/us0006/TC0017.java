package sda.capstone.API.test.us0006;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.OrganizationStatuses;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0017 extends ApiBase {

    private UserStatus orgStatusUpdatedMain = UserStatus
            .builder()
            .id(APIVars.organizationId)
            .name("active")
            .description("Organization/Company account is active")
            .build();
    @Test
    public void editOrgStatus() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(orgStatusUpdatedMain)
                .put("/a3m/auth/api/{first}");

        OrganizationStatuses orgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertSame(orgStatusResponse.getId(), orgStatusUpdatedMain.getId(), "User Status id must equal " + orgStatusUpdatedMain.getId());
        Assert.assertEquals(orgStatusUpdatedMain.getName(), orgStatusResponse.getName(), "Name = active");
        Assert.assertEquals(orgStatusUpdatedMain.getDescription(), orgStatusResponse.getDescription(), "Description = Organization/Company account is active");

        APIVars.organizationId = orgStatusResponse.getId();
    }

    @Test(dependsOnMethods = "editOrgStatus")
    public void getOrgStatusById() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");
        pathParams.put("id", APIVars.userStatusId+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        OrganizationStatuses orgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertSame(orgStatusResponse.getId(), APIVars.userStatusId, "User Status id must equal " + APIVars.userStatusId);
        Assert.assertEquals(orgStatusUpdatedMain.getName(), orgStatusResponse.getName(), "Name = active");
        Assert.assertEquals(orgStatusUpdatedMain.getDescription(), orgStatusResponse.getDescription(), "Description = Organization/Company account is active");
    }
}
