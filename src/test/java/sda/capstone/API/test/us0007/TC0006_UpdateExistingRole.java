package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.NewRole;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0006_UpdateExistingRole extends ApiWithCookieHeaderBase {
    @Test()
    public void AddNewRole() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("p1", "role");
        spec.pathParams(pathParams);

        String strJson = """
                {
                  "id": 3,
                  "name": "QA TESTER",
                  "app_id": 0,
                  "description": "string",
                  "permissions": [
                    {
                      "id": 0,
                      "resource": "job",
                      "action": "read, write etc.",
                      "app_id": 3
                    }
                  ]
                }
                 """;

        NewRole addANewRole =  ObjectMapperUtils.convertJsonToJava(strJson, NewRole.class);
        Response response = given(spec).body(addANewRole).put("/a3m/auth/api/{p1}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403, "Status code must be 403 ( Forbidden )");
    }
}