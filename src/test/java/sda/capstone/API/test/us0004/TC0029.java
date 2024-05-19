package sda.capstone.API.test.us0004;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TC0029 extends ApiBase {

    @Test
    public void GetAllApplicationMembership() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("app","application");
        pathParams.put("app_id","2");
        pathParams.put("first","membership-type");
//        {{base_url}}/auth/api/application/2/membership-type
        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{app}/{app_id}/{first}");
        response.prettyPrint();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }
}

