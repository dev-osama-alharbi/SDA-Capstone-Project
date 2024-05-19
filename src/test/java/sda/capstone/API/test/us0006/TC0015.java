package sda.capstone.API.test.us0006;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.OrganizationStatuses;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0015 extends ApiBase {

    @Test
    public void getOrganizationStatusesById() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");
        pathParams.put("id","1");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        OrganizationStatuses OrgStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses.class);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals((int) OrgStatusResponse.getId(), 1, "User Status List must not empty");
        Assert.assertEquals(OrgStatusResponse.getName(), "active", "Name = active");
        Assert.assertTrue(OrgStatusResponse.getDescription().contains("Organization"),"Check it have description");
    }
}
