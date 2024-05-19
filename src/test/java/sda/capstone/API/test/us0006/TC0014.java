package sda.capstone.API.test.us0006;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.OrganizationStatuses;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0014 extends ApiBase {

    @Test
    public void getAllOrganizationStatuses() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();
        System.out.println("response.statusCode() => "+response.statusCode());
        OrganizationStatuses[] orgStatusesArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),OrganizationStatuses[].class);
        List<OrganizationStatuses> orgStatusListResponse = new ArrayList<>(Arrays.asList(orgStatusesArraysResponse));
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!orgStatusListResponse.isEmpty(),"Organization Statuses List must not empty");
    }
}
