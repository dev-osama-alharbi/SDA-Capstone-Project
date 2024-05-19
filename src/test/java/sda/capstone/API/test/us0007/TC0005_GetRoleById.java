package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.AllRoles;
import sda.capstone.API.utilities.ObjectMapperUtils;
import static io.restassured.RestAssured.given;

public class TC0005_GetRoleById extends ApiBase {

    @Test()
    public void GetRoleById(){

        spec.pathParams("1", "a3m","2", "auth","3","api","4","role","5","2");

        Response response =given(spec).get("{1}/{2}/{3}/{4}/{5}");
        response.prettyPrint();

        AllRoles roleByIdArrayResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), AllRoles.class);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals(roleByIdArrayResponse.getId(),2);
        Assert.assertEquals(roleByIdArrayResponse.getName(),"A3M_APP_MANAGER");
        Assert.assertEquals(roleByIdArrayResponse.getApp_id(),1);
    }
}
