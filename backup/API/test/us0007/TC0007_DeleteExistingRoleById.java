package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0007_DeleteExistingRoleById extends ApiWithCookieHeaderBase {

    @Test()
    public void DeleteExistingRoleByIdTest(){
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("p1","role");
        pathParams.put("p2","2");
        pathParams.put("p3","app_id=1");
        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).delete("/a3m/auth/api/{p1}/{p2}?{p3}");
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403,"Status code must be 403 ( Forbidden )");
    }
}
