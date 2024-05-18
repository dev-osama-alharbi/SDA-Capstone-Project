package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0037 extends ApiBase {
    @Test
    public void DeleteExistingUserGroupById() {
        String id = String.valueOf(DataSaver.a);

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
