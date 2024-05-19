package sda.capstone.API.test.us0002;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.GetAllCountries;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TC0012 extends ApiBase {
    @Test
    public void getAllCountries(){
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","country");

        spec.pathParams(pathParams);

        Response response = given(spec).get("/a3m/auth/api/{first}");
        response.prettyPrint();
        System.out.println("response.statusCode() => "+response.statusCode());
        GetAllCountries[] CountriesArraysResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),GetAllCountries[].class);
        List<GetAllCountries> CountriesListResponse = new ArrayList<>(Arrays.asList(CountriesArraysResponse));
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(!CountriesListResponse.isEmpty(),"Countries List must not empty");
    }
}
