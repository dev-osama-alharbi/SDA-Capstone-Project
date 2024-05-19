package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TC0051 extends ApiWithCookieHeaderBase {




    @Test
    public void deleteUserFromOrganization (){

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization");
        pathParams.put("sub_default_org_id","1715253779444611");
        pathParams.put("second","user");
        pathParams.put("user_id","1410");

        spec.pathParams(pathParams);

        Response response = given(spec).delete("/a3m/auth/api/v1/{first}/{sub_default_org_id}/{second}/{user_id}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .body(equalTo(""));

    }

}
