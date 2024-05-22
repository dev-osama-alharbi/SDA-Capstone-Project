package sda.capstone.API.test.us0003;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllMemberships;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TC0028 extends ApiWithCookieHeaderBase {

    @Test
    public void GetMembershipUserAndAppID() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","v1");
        pathParams.put("user","user");
        pathParams.put("user_id","1404");
        pathParams.put("app","application");
        pathParams.put("app_id","2");
        pathParams.put("second","membership");
//        {{base_url}}/auth/api/v1/user/1404/application/2/membership
         spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}/{user}/{user_id}/{app}/{app_id}/{second}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403);
    }
}
