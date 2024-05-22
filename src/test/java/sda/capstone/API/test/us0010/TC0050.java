package sda.capstone.API.test.us0010;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class TC0050 extends ApiWithCookieHeaderBase {

    @Test()
    public void getUsersOfOrganizationByOrganizationIDTest()throws JsonProcessingException {


        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization");
        pathParams.put("sub_default_org_id","1716287440101561");
        pathParams.put("second","user");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/v1/{first}/{sub_default_org_id}/{second}");
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("", hasSize(greaterThan(0)));



    }
}
