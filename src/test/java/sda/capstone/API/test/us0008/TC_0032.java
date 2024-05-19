package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC_0032 extends ApiBase {

    @Test
    public void RemoveUserFromUserGroupOfTheOrganization() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user-group");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .delete("/a3m/auth/api/organization/123/{first}/123/user/123");
        response.prettyPrint();

        response.
                then().
                statusCode(403).
                body("message", equalTo("Principal not authorized"));
    }
}
