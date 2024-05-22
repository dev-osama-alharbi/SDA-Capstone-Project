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

public class TC0026 extends ApiWithCookieHeaderBase {

    @Test
    public void GetMembershipUserID() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","v1");
        pathParams.put("user","user");
        pathParams.put("id","1404");
        pathParams.put("second","membership");

///auth/api/v1/user/1404/membership
        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}/{user}/{id}/{second}");
        response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 403);
    }
}
