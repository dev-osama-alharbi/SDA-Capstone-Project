package sda.capstone.API.test.us0010;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.*;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC0054 extends ApiWithCookieHeaderBase {

    private final UserData userDataUpdated = UserData
            .builder()
            .id(1411)
            .name("Odis")
            .lastname("Doyle")
            .username("renaldo.lemke")
            .email("assurewise@assurewise.com")
            .isEmailVerified(false)
            .phone("9227532360")
            .address("Apt. 113 23709 Frami Alley, Haleyhaven, AK 35791-0045")
            .statusId(1)
            .status(UserStatus.builder()
                    .id(1)
                    .name("active")
                    .description("User account is active")
                    .build())
            .organizations(List.of(
                    OrganizationsItem.builder()
                            .id(1715253779444611L)
                            .name("XYZ Inc")
                            .founderId(1406)
                            .countryId("SA")
                            .email("xyz@example.com")
                            .createdAt("2024-05-09T11:22:59.420416Z")
                            .updatedAt("2024-05-17T14:03:45.603338Z")
                            .currency("SAR")
                            .build()
            ))
            .userGroups(Collections.emptyList())
            .roles(List.of(
                    RolesItem.builder()
                            .roleId(5)
                            .name("Business Owner")
                            .subscriptionId("2e810f91-4b7f-4d78-8d18-c5e9f7491cb8")
                            .isDefault(true)
                            .build()
            ))
            .applications(List.of(
                    ApplicationsItem.builder()
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
                            .updatedBy(1)
                            .build()
            ))
            .createdAt("2024-04-30T15:04:14.318965Z")
            .createdBy(2)
            .updatedAt("2024-05-17T14:55:24.038618Z")
            .updatedBy(1787)
            .organizationId(1715253779444611L)
            .subscriptionId("2e810f91-4b7f-4d78-8d18-c5e9f7491cb8")
            .isActive(true)
            .membershipCreatedAt("2024-05-17T08:28:35.080717Z")
            .membershipUpdatedAt("2024-05-17T08:28:35.080718Z")
            .build();



    @Test
    public void putExistingUserDataTest() {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "user");

        spec.pathParams(pathParams);

        System.out.println("Request Payload: " + userDataUpdated);

        Response response = given()
                .spec(spec)
                .body(userDataUpdated)
                .put("/a3m/auth/api/v1/{first}");
        response.prettyPrint();


        System.out.println("Response Body: " + response.getBody().asString());

        UserData UserDataResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserData.class);
      System.out.println("UserDataResponse = " + UserDataResponse);


        response.then().statusCode(200)
                .body(
                       "name", equalTo(userDataUpdated.getName()),
                       "lastname", equalTo(userDataUpdated.getLastname()),
                      "username", equalTo(userDataUpdated.getUsername()),
                       "email", equalTo(userDataUpdated.getEmail()));

    }

}
