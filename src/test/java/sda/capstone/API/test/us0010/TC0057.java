package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TC0057 extends ApiWithCookieHeaderBase {




    @Test
    public void deleteExistingUserByID (){

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user");
        pathParams.put("user_id","1817");

        spec.pathParams(pathParams);

        Response response = given(spec).delete("/a3m/auth/api/v1/{first}/{user_id}");
        response.prettyPrint();


        response
                .then()
                .statusCode(403);

    }

}
