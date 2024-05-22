package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0037 extends ApiWithCookieHeaderBase {
    @Test
    public void DeleteExistingUserGroupById() {
        String id = String.valueOf(APIVars.UserGroupID);

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user-group");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .delete("/a3m/auth/api/{first}/"+id);
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
