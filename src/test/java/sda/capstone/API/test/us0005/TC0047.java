package sda.capstone.API.test.us0005;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0047 extends ApiWithCookieHeaderBase {

    @Test
    public void deleteOrganizationByIdTest(){
        String strOrgId = null; //String.valueOf(APIVars.read().getOrganizationId());   //uncomment
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization");
        pathParams.put("org_id",strOrgId);

        spec.pathParams(pathParams);
        Response response = given(spec).delete("/a3m/auth/api/{first}/{org_id}");


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
        Assert.assertTrue(response.body().asString().isEmpty(), "Delete response body should be empty");
    }

    @Test(dependsOnMethods = "deleteOrganizationByIdTest")
    public void getOrganizationByIdAndVerifyIsDeletedTest(){
        String strOrgId = null; //String.valueOf(APIVars.read().getOrganizationId()); //uncomment
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "v1");
        pathParams.put("second", "organization");
        pathParams.put("third", "summary");
        pathParams.put("org_id",strOrgId);


        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{second}/{org_id}/{third}");
        response.prettyPrint();


        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 406, "Status code should be 406");
        Assert.assertTrue(response.body().asString().contains("Organization subscription could not found with given ID"));
    }

}

/**
 * TODO: add the following in 'APIVarsModel'
 * public Long organizationId= null;
 * TODO: add the following in 'APIVars'
 * public static boolean writeOrganizationId(Long organizationId){
 *         return write(APIVarsModel.builder().organizationId(organizationId).build());
 *     }
 * TODO: Uncomment commented lines
 * in 44,45,46,47
 */


