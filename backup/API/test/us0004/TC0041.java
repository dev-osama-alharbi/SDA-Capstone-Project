package sda.capstone.API.test.us0004;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0041 extends ApiBase {
    @Test
    public void DeleteExistingMembershipTypeById() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "membership-type");
        pathParams.put("id", "5");

//{{base_url}}/auth/api/membership-type/5
        spec.pathParams(pathParams);
        Response response = RestAssured.given(spec)
                .delete("/a3m/auth/api/{first}/{id}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403);
    }
}