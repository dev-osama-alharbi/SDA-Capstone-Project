package sda.capstone.API.test.us0009;

import io.restassured.response.Response;
import org.testng.Assert;
import sda.capstone.API.ApiWithCookieHeaderBase;
import sda.capstone.API.pojo.UserStatus;
import sda.capstone.API.utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_0020 extends ApiWithCookieHeaderBase {}
//    HashMap<String,String> pathParams = new HashMap<>();
//        pathParams.put("first","user-group-type");
//        pathParams.put("id","145");
//
//        spec.pathParams(pathParams);
//    Response response = given(spec)
//            .get("/a3m/auth/api/{first}/{id}");
//
//    UserStatus userStatusResponse = ObjectMapperUtils.convertJsonToJava(response.asString(),UserStatus.class);
//
//    int statusCode = response.statusCode();
//
//        Assert.assertEquals(statusCode, 200 ,"Status code must be 200");
//        Assert.assertTrue(userStatusResponse.getId() == 145,"User Status List must not empty");
//        Assert.assertTrue(userStatusResponse.getName().equals("dep"),"Check the Name = 'dep'");
//        Assert.assertTrue(userStatusResponse.getDescription().contains("Organization unit which is not located within company premises, such as remote office, remote branch or warehouse etc"),"Check it have description");
//}
//}
//
