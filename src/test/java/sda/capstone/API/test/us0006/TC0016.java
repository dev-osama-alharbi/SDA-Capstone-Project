package sda.capstone.API.test.us0006;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.OrganizationStatuses;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0016 extends ApiBase {

    private OrganizationStatuses orgStatusMain = OrganizationStatuses
            .builder()
            .id(null)
            .name("active")
            .description("Organization/Company account is active")
            .build();
    @Test
    public void AddNewOrganizationStatus(){
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(orgStatusMain)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();
        OrganizationStatuses organizationStatusesResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 201 ,"Status code must be 201");
        Assert.assertTrue(organizationStatusesResponse.getId() != 0,"User Status id must not 0");
        Assert.assertEquals(orgStatusMain.getName(), organizationStatusesResponse.getName(), "active");
        Assert.assertEquals(orgStatusMain.getDescription(), organizationStatusesResponse.getDescription(), "Organization/Company account is active");

        APIVars.organizationId = organizationStatusesResponse.getId();
    }

    @Test(dependsOnMethods = "AddNewOrganizationStatus")
    public void getOrganizationStatusById() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");
        pathParams.put("id", APIVars.organizationId+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        OrganizationStatuses organizationStatusesResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals(APIVars.userStatusId, organizationStatusesResponse.getId(), "User Status id must equal " + APIVars.userStatusId);
        Assert.assertEquals(orgStatusMain.getName(), organizationStatusesResponse.getName(), "Name = active");
        Assert.assertEquals(orgStatusMain.getDescription(), organizationStatusesResponse.getDescription(), "Description = Organization/Company account is active");
    }
}
