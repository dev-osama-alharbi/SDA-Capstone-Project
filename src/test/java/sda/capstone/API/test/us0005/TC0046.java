package sda.capstone.API.test.us0005;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.OrganizationService;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0046 extends ApiWithCookieHeaderBase {
    @Test
    public void getOrganizationByIdTest(){
        String id = String.valueOf(1715947853784012L); //TODO: Edit (dynamic)
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "v1");
        pathParams.put("second", "organization");
        pathParams.put("third", "summary");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{second}/" + id + "/{third}");
        response.prettyPrint();

        OrganizationService organizationResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), OrganizationService.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200, "Status code should be 200");
        Assert.assertNotNull(organizationResponse, "Update response body should not be null");
    }
}
