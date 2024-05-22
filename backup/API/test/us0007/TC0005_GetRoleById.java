package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllRoles;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0005_GetRoleById extends ApiWithCookieHeaderBase {

    @Test()
    public void GetRoleByIdTest(){

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("p1","role");
        pathParams.put("p2","2");
        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/{p1}/{p2}");
        response.prettyPrint();

        AllRoles roleByIdArrayResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), AllRoles.class);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals(roleByIdArrayResponse.getId(),2);
        Assert.assertEquals(roleByIdArrayResponse.getName(),"A3M_APP_MANAGER");
        Assert.assertEquals(roleByIdArrayResponse.getApp_id(),1);
    }
}
