package sda.capstone.API.test.us0010;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0055 extends ApiWithCookieHeaderBase {

    @Test
    public void getUsersOfUserGroupsByUserGroupIDTest()throws JsonProcessingException {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user-group");
        pathParams.put("user_group_id","1371");
        pathParams.put("second","user");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/v1/{first}/{user_group_id}/{second}");
        response.prettyPrint();


        response.then().statusCode(403);



    }
}
