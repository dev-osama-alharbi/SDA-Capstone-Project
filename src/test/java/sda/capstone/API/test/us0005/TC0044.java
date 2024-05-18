package sda.capstone.API.test.us0005;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.API.APIVars;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.OrganizationService;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC0044 extends ApiWithCookieHeaderBase {
    private OrganizationService organizationServiceBody = OrganizationService
            .builder()
            .id(null)
            .name("Team4Company")
            .founder_id(1)
            .short_name("T4C")
            .country_id("SA")
            .phone("0591234567")
            .email("t4@email.com")
            .website("www.team4.com")
            .fax("966591234567")
            .status_id(2)
            .currency("SAR")
            .address("4th Street")
            .build();

    @Test
    public void addNewOrganizationTest() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "organization");

        spec.pathParams(pathParams);
        Response response = given(spec)
                .body(organizationServiceBody)
                .post("/a3m/auth/api/{first}");
        response.prettyPrint();

        OrganizationService addOrganizationResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), OrganizationService.class);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 201, "Status code should be 201");
        Assert.assertTrue((addOrganizationResponse.getId()) != 0, "organization id must not be 0");
        Assert.assertEquals(addOrganizationResponse.getName(), organizationServiceBody.getName(), "Name assertion failed");
        Assert.assertEquals(addOrganizationResponse.getFounder_id(), organizationServiceBody.getFounder_id(), "Founder ID assertion failed");
        Assert.assertEquals(addOrganizationResponse.getShort_name(), organizationServiceBody.getShort_name(), "Short name assertion failed");
        Assert.assertEquals(addOrganizationResponse.getCountry_id(), organizationServiceBody.getCountry_id(), "Country ID assertion failed");
        Assert.assertEquals(addOrganizationResponse.getPhone(), organizationServiceBody.getPhone(), "Phone assertion failed");
        Assert.assertEquals(addOrganizationResponse.getEmail(), organizationServiceBody.getEmail(), "Email assertion failed");
        Assert.assertEquals(addOrganizationResponse.getWebsite(), organizationServiceBody.getWebsite(), "Website assertion failed");
        Assert.assertEquals(addOrganizationResponse.getStatus_id(), organizationServiceBody.getStatus_id(), "Status ID assertion failed");
        Assert.assertEquals(addOrganizationResponse.getFax(), organizationServiceBody.getFax(), "Fax assertion failed");
        Assert.assertEquals(addOrganizationResponse.getCurrency(), organizationServiceBody.getCurrency(), "Currency assertion failed");
        Assert.assertEquals(addOrganizationResponse.getAddress(), organizationServiceBody.getAddress(), "Address assertion failed");

//        APIVars.writeOrganizationId(addOrganizationResponse.getId()); //uncomment
    }

    @Test
    public void verifyOrganizationAddedExist(){
        String strOrgId = null; //String.valueOf(APIVars.read().getOrganizationId()); //uncomment
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("first", "v1");
        pathParams.put("second", "organization");
        pathParams.put("third", "summary");
        pathParams.put("org_id", strOrgId);

        spec.pathParams(pathParams);
        Response response = given(spec)
                .get("/a3m/auth/api/{first}/{second}/{org_id}/{third}");
        response.prettyPrint();

        OrganizationService organizationByIdResponse = ObjectMapperUtils.convertJsonToJava(response.asString(), OrganizationService.class);

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
//        Assert.assertEquals(organizationByIdResponse.getId(), APIVars.read().getOrganizationId() ,"Organization id must equal "+ APIVars.read().getOrganizationId());
    }
}
