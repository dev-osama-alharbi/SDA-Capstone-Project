package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0033 extends ApiWithCookieHeaderBase {
    @Test
    public void GetAllUserGroups() {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user-group");
        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
