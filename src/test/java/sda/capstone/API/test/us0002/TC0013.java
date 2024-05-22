package sda.capstone.API.test.us0002;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.Countries;
import sda.capstone.API.pojo.CountriesV2;
import sda.capstone.API.utilities.ObjectMapperUtils;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0013 extends ApiWithCookieHeaderBase {
    @Test
    public void getAllCountriesById() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","country");
        pathParams.put("id","SA");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}/{id}");
        response.prettyPrint();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ -> statusCode = "+response.statusCode());
//        Countries GetAllCountriesResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),Countries.class);
        CountriesV2 GetAllCountriesResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),CountriesV2.class);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals(GetAllCountriesResponse.getIso2(), "SA", "Countrie Id is SA");
        Assert.assertEquals(GetAllCountriesResponse.getName(), "Saudi Arabia", "Name = 'Saudi Arabia'");
    }
}
