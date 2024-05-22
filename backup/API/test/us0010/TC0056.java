package sda.capstone.API.test.us0010;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC0056 extends ApiWithCookieHeaderBase {

    @Test
    public void getUserByIDTest()throws JsonProcessingException {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user");
        pathParams.put("user_id","37");


        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/v1/{first}/{user_id}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .body(  "id", Matchers.equalTo(37),
                        "email", Matchers.equalTo("t4@testevolve.com"),
                        "username", Matchers.equalTo("t4@testevolve.com"));



    }
}
