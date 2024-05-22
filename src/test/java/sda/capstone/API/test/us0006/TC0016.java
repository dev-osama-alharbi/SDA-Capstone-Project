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

public class TC0016 extends ApiWithCookieHeaderBase {

    private UserStatus orgStatusMain = UserStatus
            .builder()
            .id(null)
            .name("active")
            .description("Organization/Company account is active")
            .build();
    @Test
    public void addOrgStatus() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(orgStatusMain)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();
        OrganizationStatuses orgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 201 ,"Status code must be 201");
        Assert.assertTrue(orgStatusResponse.getId() != 0,"Organization Status id must not 0");
        Assert.assertEquals(orgStatusMain.getName(), orgStatusResponse.getName(), "Name = 'active'");
        Assert.assertEquals(orgStatusMain.getDescription(), orgStatusResponse.getDescription(), "description = Organization/Company account is active");

        APIVars.writeOrgStatusId(orgStatusResponse.getId());
    }

    @Test(dependsOnMethods = "addOrgStatus")
    public void getOrgStatusById() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");
        pathParams.put("id", APIVars.read().getOrgStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");
        response.prettyPrint();
        System.out.println("@@@@@@@@@@@@@@@@@");

        OrganizationStatuses orgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();
        System.out.println("orgStatusResponse.getId() = "+orgStatusResponse.getId() +" && APIVars.orgStatusId = "+APIVars.read().getOrgStatusId());
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals(APIVars.read().getOrgStatusId(), orgStatusResponse.getId(), "Organization Status id must equal " + APIVars.read().getOrgStatusId());
        Assert.assertEquals(orgStatusMain.getName(), orgStatusResponse.getName(), "Name = 'active'");
        Assert.assertEquals(orgStatusMain.getDescription(), orgStatusResponse.getDescription(), "Check it have description");
    }
}
