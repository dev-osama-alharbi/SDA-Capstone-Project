package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.AllRoles;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0003_GetRolesBySubscription extends ApiBase {
    @Test
    public void GetAllRolesByOrganization() {

        spec.pathParams("1", "a3m","2", "auth","3","api","4","role");

        Response response =given(spec).get("{1}/{2}/{3}/{4}");
        response.prettyPrint();

        AllRoles rolesBySubscriptionArrayResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), AllRoles.class);
        List<AllRoles> rolesBySubscriptionListResponse = new ArrayList<>(Arrays.asList(rolesBySubscriptionArrayResponse));
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertFalse(rolesBySubscriptionListResponse.isEmpty(),"User Status List must not empty");

    }
}

