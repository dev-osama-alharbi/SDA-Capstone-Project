package sda.capstone.API.test.us0010;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC0056 extends ApiWithCookieHeaderBase {

    @Test
    public void getUserByIDTest()throws JsonProcessingException {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user");



        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/v1/{first}/"+APIVars.read().getNewUserId());
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .body(  "id", equalTo(APIVars.read().getNewUserId()));



    }
}
