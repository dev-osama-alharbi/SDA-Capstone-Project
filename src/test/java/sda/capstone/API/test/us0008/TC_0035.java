package sda.capstone.API.test.us0008;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.Organization;
import sda.capstone.API.pojo.UserGroupService;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class TC_0035 extends ApiWithCookieHeaderBase {
   private Organization organization = Organization
            .builder().
            id(1715291982442328L).
            name("Jeanice").
            founder_id(140).
            email("valentine.monahan@gmail.com").
            created_at("2024-05-09T21:59:42.432370Z").
            updated_at("2024-05-15T11:55:19.863143Z").
            build();

    private UserGroupService userGroupService = UserGroupService
            .builder().
            id(null).
            name("Quality assurance Quality assurance").
            organization_id(1715291982442328L).
            organization(organization).
            users(null).
            roles(null).
            build();



    @Test
    public void AddNewUserGroup() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user-group");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(userGroupService)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();

        UserGroupService userGroupService1 = ObjectMapperUtils.convertJsonToJava(response.asString(),UserGroupService.class);
        int statusCode = response.statusCode();
        APIVars.writeUserGroupID(userGroupService1.getId());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 201);
        softAssert.assertEquals(userGroupService1.getName(),"Quality assurance Quality assurance");
        softAssert.assertAll();
    }
}
