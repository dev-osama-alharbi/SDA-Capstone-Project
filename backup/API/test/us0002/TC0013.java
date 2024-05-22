package sda.capstone.API.test.us0002;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.Countries;
import sda.capstone.API.utilities.ObjectMapperUtils;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0013 extends ApiBase {
    @Test
    public void getAllCountriesById() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","country");
        pathParams.put("id","1");

        spec.pathParams(pathParams);

        Response response = RestAssured.given(spec).get("/a3m/auth/api/{first}/{id}");
        Countries GetAllCountriesResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),Countries.class);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertEquals((int) GetAllCountriesResponse.getId(), 1, "Countries List must not empty");
        Assert.assertEquals(GetAllCountriesResponse.getName(), "active", "Name = 'active'");
        Assert.assertTrue(GetAllCountriesResponse.getDescription().contains("Country"),"Check it have description");
    }
}
