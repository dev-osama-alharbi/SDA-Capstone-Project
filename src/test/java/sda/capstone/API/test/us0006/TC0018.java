package sda.capstone.API.test.us0006;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0018 extends ApiBase {

    @Test
    public void deleteOrganizationStatusById(){
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");
        pathParams.put("id",APIVars.read().getOrgStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .delete("/a3m/auth/api/{first}/{id}");
        response.prettyPrint();
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
    }

    @Test(dependsOnMethods = "deleteOrganizationStatusById")
    public void getOrganizationStatusById(){
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization-status");
        pathParams.put("id", APIVars.read().getOrgStatusId()+"");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{id}");

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 404 ,"Status code must be 404");
    }
}
