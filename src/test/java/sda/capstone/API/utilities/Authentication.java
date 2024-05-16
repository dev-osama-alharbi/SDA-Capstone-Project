package sda.capstone.API.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {
    public static String generateToken(String username, String password) {

        Response response = given()
                .formParam("grant_type", "password")
                .formParam("username", username)
                .formParam("password", password)
                .post("https://qa-gm3.quaspareparts.com/token");
        //response.prettyPrint();

        return response.jsonPath().getString("access_token");
    }
}
