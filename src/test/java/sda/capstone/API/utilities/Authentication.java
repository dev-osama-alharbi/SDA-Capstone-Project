package sda.capstone.API.utilities;


import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    public static String generateGSessionId(String username_ui, String password_ui) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-gm3.quaspareparts.com");
        driver.findElement(By.className("login-button")).click();
        driver.findElement(By.id("username")).sendKeys(username_ui);
        driver.findElement(By.id("password")).sendKeys(password_ui);
        driver.findElement(By.tagName("button")).click();
        String cookie = String.valueOf(driver.manage().getCookieNamed("GSESSIONID"));
        driver.quit();

        return cookie;
    }
}