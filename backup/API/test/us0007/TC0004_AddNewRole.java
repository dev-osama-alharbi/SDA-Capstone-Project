package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllRoles;
import sda.capstone.API.pojo.NewRole;
import sda.capstone.API.pojo.PermissionsItem;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0004_AddNewRole extends ApiWithCookieHeaderBase {

    @Test()
    public void AddNewRole() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("p1", "role");
        spec.pathParams(pathParams);

        String strJson = """
                {
                  "id": 123,
                  "name": "TESTER",
                  "app_id": 0,
                  "description": "string",
                  "permissions": [
                    {
                      "id": 0,
                      "resource": "book",
                      "action": "read, write etc.",
                      "app_id": 123
                    }
                  ]
                }
                 """;

        NewRole addANewRole =  ObjectMapperUtils.convertJsonToJava(strJson, NewRole.class);
        Response response = RestAssured.given(spec).body(addANewRole).post("/a3m/auth/api/{p1}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403, "Status code must be 403 ( Forbidden )");
    }
}
