package sda.capstone.API.test.us0004;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.ApiBase;
import sda.capstone.API.pojo.MembershipType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0039 extends ApiBase {

    private MembershipType MembershipTypeUpdatedMain = MembershipType
            .builder()
            .id(6)
            .name("Added Guest Membership")
            .short_name("Added Guest Membr.")
            .is_enabled(true)
            .is_individual_plan(true)
            .default_role_id(6)
            .subscription_type_id(6)
            .app_id(2)
            .created_at("2023-01-17T19:50:28.504820Z")
            .updated_at("2023-01-17T19:52:09.603577Z")
            .build();

    @Test
    public void AddNewMembershipType() throws JsonProcessingException {
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("first","membership-type");
//{{base_url}}/auth/api/membership-type
        spec.pathParams(pathParams);
        Response response = RestAssured.given(spec)
                .body(MembershipTypeUpdatedMain)
                .post("/a3m/auth/api/{first}");

        int statusCode = response.statusCode();
        response.prettyPrint();
        Assert.assertEquals(statusCode, 403 );

    }


}
