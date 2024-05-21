package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC0051 extends ApiWithCookieHeaderBase {

    @Test
    public void deleteUserFromOrganization() {
        Integer newUserId = APIVars.read().getNewUserId();
        System.out.println("New User ID to be deleted: " + newUserId);

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "organization");
        pathParams.put("sub_default_org_id", "1");
        pathParams.put("second", "user");

        spec.pathParams(pathParams);

        Response response = given(spec)
                .delete("/a3m/auth/api/v1/{first}/{sub_default_org_id}/{second}/" + newUserId);
        response.prettyPrint();

        response.then().statusCode(200).body(equalTo(""));
    }
}
