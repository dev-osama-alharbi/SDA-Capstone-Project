package sda.capstone.API.test.us0005;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.Organization;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0045 extends ApiWithCookieHeaderBase {

    @Test
    public void updateExistingOrganizationTest() {
        Organization organizationUpdateBody = Organization
                .builder()
                .id(APIVars.read().getOrganizationId())
                .name("Updated Team4Company")
                .founder_id(1)
                .short_name("Team4C")
                .country_id("SA")
                .phone("0591234567")
                .email("team4@email.com")
                .website("www.team4company.com")
                .fax("966591234567")
                .status_id(3)
                .currency("SAR")
                .address("4th Street")
                .build();

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "organization");

        spec.pathParams(pathParams);
        Response response = RestAssured.given(spec)
                .body(organizationUpdateBody)
                .put("/a3m/auth/api/{first}");
        response.prettyPrint();

        Organization updateOrganizationResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), Organization.class);
        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200, "Status code should be 200");
        Assert.assertEquals(updateOrganizationResponse.getId(), organizationUpdateBody.getId(), "ID assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getName(), organizationUpdateBody.getName(), "Name assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getFounder_id(), organizationUpdateBody.getFounder_id(), "Founder ID assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getShort_name(), organizationUpdateBody.getShort_name(), "Short name assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getCountry_id(), organizationUpdateBody.getCountry_id(), "Country ID assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getPhone(), organizationUpdateBody.getPhone(), "Phone assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getEmail(), organizationUpdateBody.getEmail(), "Email assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getWebsite(), organizationUpdateBody.getWebsite(), "Website assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getStatus_id(), organizationUpdateBody.getStatus_id(), "Status ID assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getFax(), organizationUpdateBody.getFax(), "Fax assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getCurrency(), organizationUpdateBody.getCurrency(), "Currency assertion failed");
        Assert.assertEquals(updateOrganizationResponse.getAddress(), organizationUpdateBody.getAddress(), "Address assertion failed");
    }

}
