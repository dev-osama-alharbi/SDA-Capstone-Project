package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.*;
import java.util.HashMap;
import static io.restassured.RestAssured.given;


public class TC0052 extends ApiWithCookieHeaderBase {


    @Test
    public void postAddNewUserManuallyTest(){

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","organization");
        pathParams.put("second","user");
        pathParams.put("third","register-manual");

        spec.pathParams(pathParams);

        String strJson = """
                {
                    "id": 0,
                    "name": "John",
                    "lastname": "Doe",
                    "username": "john",
                    "email": "john@example.com",
                    "is_email_verified": true,
                    "phone": "+1 123 123 4567",
                    "address": "string",
                    "country_id": "US",
                    "pic_id": 12345,
                    "preferences": {},
                    "status_id": 12345,
                    "user_groups": [
                        {
                            "id": 0,
                            "name": "Sales Department",
                            "short_name": "Sales Dept.",
                            "group_type_id": 0,
                            "pic_id": 12345,
                            "organization_id": 12345,
                            "is_head": false
                        }
                    ],
                    "created_at": "2024-05-18T18:55:55.007Z",
                    "created_by": 0,
                    "updated_at": "2024-05-18T18:55:55.007Z",
                    "updated_by": 0,
                    "organization_id": 123,
                    "organization_name": "Acme LLC",
                    "app_id": 123,
                    "membership_type_id": 0,
                    "default_role_id": 0,
                    "subscription_type_id": 0,
                    "subscription_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                    "is_individual_membership": true,
                    "password": "string",
                    "is_owner": true,
                    "is_active": true,
                    "is_default": true,
                    "membership_created_at": "2024-05-18T18:55:55.007Z",
                    "membership_updated_at": "2024-05-18T18:55:55.007Z"
                }""";

        Response response = given(spec)
                .body(strJson)
                .post("/a3m/auth/api/v1/{first}/{second}/{third}");
        response.prettyPrint();


//
       response.then().statusCode(403);

    }
}
