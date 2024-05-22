package sda.capstone.API.test.us0010;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class TC0053 extends ApiWithCookieHeaderBase {

    @Test
    public void getUsersWithKeySetPaginationTest()throws JsonProcessingException {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","user");

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("content", "full");
        queryParams.put("searchType", "contains");
        queryParams.put("sortBy", "username");
        queryParams.put("sortOrder", "ACS");


        spec.pathParams(pathParams).queryParams(queryParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/v1/{first}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .body("records.size()", Matchers.greaterThan(0));



    }
}
