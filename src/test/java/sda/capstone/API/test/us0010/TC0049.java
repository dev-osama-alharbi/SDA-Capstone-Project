package sda.capstone.API.test.us0010;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class TC0049 extends ApiWithCookieHeaderBase {

    @Test
    public void getUsersOfApplicationByApplicationIDTest()throws JsonProcessingException {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","application");
        pathParams.put("app_id","2");
        pathParams.put("second","user");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/v1/{first}/{app_id}/{second}");
        response.prettyPrint();


        response.then().statusCode(403);



    }
}
