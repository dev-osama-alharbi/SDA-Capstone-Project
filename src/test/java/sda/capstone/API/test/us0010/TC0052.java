package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserData;
import sda.capstone.API.pojo.UserDataV2;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0052 extends ApiWithCookieHeaderBase {

    @Test
    public void postAddNewUserManuallyTest() {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "organization");
        pathParams.put("second", "user");
        pathParams.put("third", "register-manual");

        spec.pathParams(pathParams);
        String email = "Team4Email"+System.currentTimeMillis()+"@gmail.com";
        APIVars.writeEmail(email);
        UserDataV2 userData = UserDataV2
                .builder()
                .app_id(2)
                .organization_id(1716287440101561L)
                .email(email)
                .subscription_id("12e01972-a928-43f9-a20c-d8df7ff926e7")
                .default_role_id(5)
                .build();

        Response response = given(spec)
                .body(userData)
                .post("/a3m/auth/api/v1/{first}/{second}/{third}");
        response.prettyPrint();

        UserData addNewUserResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), UserData.class);
        System.out.println("addNewUserResponse = " + addNewUserResponse);

        Integer newUserId = addNewUserResponse.getId();
        System.out.println("New User ID: " + newUserId);

        APIVars.newUserId = newUserId;
        APIVars.writeNewUserId(newUserId);

        response.then().statusCode(201);
    }
}
