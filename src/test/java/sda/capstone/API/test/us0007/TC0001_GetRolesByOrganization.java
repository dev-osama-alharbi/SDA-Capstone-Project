package sda.capstone.API.test.us0007;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.AllRoles;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC0001_GetRolesByOrganization extends ApiWithCookieHeaderBase {

/*
API_GET✅ , UI_GET❌
 */
    @Test
    public void GetAllRolesByOrganization() {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("p1","application");
        pathParams.put("p2","2");
        pathParams.put("p3","organization");
        pathParams.put("p4","1715253779444611");
        pathParams.put("p5","role");

//        spec.pathParams("1", "application",
//                "2", "2",
//                "3","organization",
//                "4","1715253779444611",
//                "5","role");
        spec.pathParams(pathParams);

        Response response =given(spec).get("/a3m/auth/api/{p1}/{p2}/{p3}/{p4}/{p5}");
        response.prettyPrint();

        AllRoles[] rolesByOrganizationArrayResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), AllRoles[].class);
        List<AllRoles> rolesByOrganizationListResponse = new ArrayList<>(Arrays.asList(rolesByOrganizationArrayResponse));
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertFalse(rolesByOrganizationListResponse.isEmpty(),"User Status List must not empty");

    }
}
