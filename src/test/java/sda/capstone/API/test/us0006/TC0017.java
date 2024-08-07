package sda.capstone.API.test.us0006;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.OrganizationStatuses;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0017 extends ApiWithCookieHeaderBase {
    @Test
    public void editOrgStatus() {
     OrganizationStatuses orgStatusUpdatedMain = OrganizationStatuses
            .builder()
            .id(APIVars.read().getOrgStatusId())
            .name("active")
            .description("Organization/Company account is active")
            .build();

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(orgStatusUpdatedMain)
                .put("/a3m/auth/api/{first}");
        response.prettyPrint();
        OrganizationStatuses orgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertSame(orgStatusResponse.getId(), orgStatusUpdatedMain.getId(), "Organization Status id must equal " + orgStatusUpdatedMain.getId());
        Assert.assertEquals(orgStatusUpdatedMain.getName(), orgStatusResponse.getName(), "Name = active");
        Assert.assertEquals(orgStatusUpdatedMain.getDescription(), orgStatusResponse.getDescription(), "Description = Organization/Company account is active");
    }

    @Test(dependsOnMethods = "editOrgStatus")
    public void getOrgStatusById() {
        OrganizationStatuses orgStatusUpdatedMain = OrganizationStatuses
                .builder()
                .id(APIVars.read().getOrgStatusId())
                .name("active")
                .description("Organization/Company account is active")
                .build();

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-status");
        pathParams.put("id", APIVars.read().getOrgStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        OrganizationStatuses orgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertSame(orgStatusResponse.getId(), APIVars.read().getOrgStatusId(), "Organization Status id must equal " + APIVars.read().getOrgStatusId());
        Assert.assertEquals(orgStatusUpdatedMain.getName(), orgStatusResponse.getName(), "Name = active");
        Assert.assertEquals(orgStatusUpdatedMain.getDescription(), orgStatusResponse.getDescription(), "Description = Organization/Company account is active");
    }
}
