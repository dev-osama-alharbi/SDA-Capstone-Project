package sda.capstone.API.test.us0004;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TC0030 extends ApiBase {

    @Test
    public void GetAllMembershipTypes() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","membership-type");
//       {{base_url}}/auth/api/membership-type
        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);


    }
}

