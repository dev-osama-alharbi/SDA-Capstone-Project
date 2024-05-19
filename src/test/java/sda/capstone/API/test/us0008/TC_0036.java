package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC_0036 extends ApiBase {
    @Test
    public void GetUserGroupById() {
        String id = String.valueOf(APIVars.UserGroupID);

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user-group");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/"+id);
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("name", equalTo("Quality assurance Quality assurance"));
    }
}