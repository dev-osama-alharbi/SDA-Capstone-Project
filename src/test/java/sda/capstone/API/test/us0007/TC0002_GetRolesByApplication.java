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

public class TC0002_GetRolesByApplication extends ApiBase {
    @Test
    public void GetAllRolesByOrganization() {

        spec.pathParams("1", "a3m","2", "auth","3","api","4","application","5","2","6","role");

        Response response =given(spec).get("{1}/{2}/{3}/{4}/{5}/{6}");
        response.prettyPrint();

        AllRoles rolesByApplicationArrayResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), AllRoles.class);
        List<AllRoles> rolesByApplicationListResponse = new ArrayList<>(Arrays.asList(rolesByApplicationArrayResponse));
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertFalse(rolesByApplicationListResponse.isEmpty(),"User Status List must not empty");

    }
}

