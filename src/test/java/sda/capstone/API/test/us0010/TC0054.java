package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.*;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.Collections;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC0054 extends ApiWithCookieHeaderBase {

    @Test
    public void putExistingUserDataTest() {
        UserData userDataUpdated = UserData
                .builder()
                .id(APIVars.read().getNewUserId())
                .name("relly")
                .username("relly@gmail.com")
                .email("AddNewUserTeam4@gmail.com")
                .is_email_verified(false)
                .status_id(1)
                .UserStatus(Collections.singletonList(UserStatus.builder()
                        .id(1)
                        .name("Active")
                        .description("User account is activated and authorized to use the application")
                        .build()))
                .Organization(Collections.singletonList(
                        Organization.builder()
                                .id(1)
                                .name("Acme LLC")
                                .founder_id(2)
                                .short_name("Acme")
                                .address("Ronald Avenue McMillan Drive No. 5, Tysons, Virginia")
                                .phone("15555555555")
                                .email("contact@acme.com")
                                .website("www.acme.com")
                                .fax("15555555555")
                                .status_id(1)
                                .organization_group_id(2)
                                .created_at("2023-01-17T20:35:06.419830Z")
                                .updated_at("2023-02-22T10:54:14.929604Z")
                                .currency("USD")
                                .build()
                ))
                .userGroups(Collections.singletonList(
                        User_groups.builder()
                                .id(1)
                                .name("Marketing and Sales Department")
                                .short_name("M&A Dept.")
                                .group_type_id(1)
                                .organization_id(1)
                                .is_head(false)
                                .build()
                ))
                .Roles(Collections.singletonList(
                        Roles.builder()
                                .id(5)
                                .name("Business Owner")
                                .subscriptionId("ba361a19-5fbb-4366-b425-50230f1d7918")
                                .isDefault(true)
                                .build()
                ))
                .Applications(Collections.singletonList(
                        Applications.builder()
                                .id(2)
                                .name("Quaspareparts Gateway App")
                                .shortName("Quaspareparts")
                                .description("Cloud Gateway Reverse Proxy Service")
                                .baseUri("https://qa-gm3.quaspareparts.com")
                                .domainName("gm3.quaspareparts.com")
                                .environment("Development")
                                .defaultMembershipTypeId(6)
                                .isEnabled(true)
                                .isSubscriptionRequired(false)
                                .isSelfRegistrationEnabled(false)
                                .isPasswordRecoveryEnabled(true)
                                .isExternalIdpLoginEnabled(false)
                                .isMfaEnabled(false)
                                .subscriptionPath("-")
                                .loginPath("/auth/login")
                                .logoId(2)
                                .createdAt("2023-01-17T19:50:28.204649Z")
                                .updatedAt("2024-03-11T11:09:14.589300Z")
                                .updated_by(1)
                                .build()
                ))
                .created_at("2024-05-20T12:00:56.693070Z")
                .created_by(37)
                .updated_at("2024-05-20T12:36:23.553672Z")
                .updated_by(25)
                .organizationId(1)
                .subscriptionId("ba361a19-5fbb-4366-b425-50230f1d7918")
                .isActive(true)
                .membershipCreatedAt("2024-05-20T14:18:41.344896Z")
                .membershipUpdatedAt("2024-05-20T14:18:41.344896Z")
                .build();

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user");

        spec.pathParams(pathParams);

        System.out.println("newUserId = " + APIVars.read().getNewUserId());

        System.out.println("Request Payload: " + userDataUpdated);

        Response response = given()
                .spec(spec)
                .body(userDataUpdated)
                .put("/a3m/auth/api/v1/{first}");

        response.prettyPrint();
        System.out.println("Response Body: " + response.getBody().asString());

        UserData UserDataResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), UserData.class);
        System.out.println("UserDataResponse = " + UserDataResponse);

        response.then().statusCode(200)
                .body(
                        "username", equalTo(userDataUpdated.getUsername()),
                        "email", equalTo(userDataUpdated.getEmail())
                );
    }
}
