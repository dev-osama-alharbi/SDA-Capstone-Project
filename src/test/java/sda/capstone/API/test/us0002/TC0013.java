package sda.capstone.API.test.us0002;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.GetAllCountries;
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

        Response response = given(spec).get("/a3m/auth/api/{first}/{id}");
        GetAllCountries GetAllCountriesResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),GetAllCountries.class);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(GetAllCountriesResponse.getId() == 1,"User Status List must not empty");
        Assert.assertTrue(GetAllCountriesResponse.getName().equals("active"),"Check the Name = 'active'");
        Assert.assertTrue(GetAllCountriesResponse.getDescription().contains("User account"),"Check it have description");
    }
}
