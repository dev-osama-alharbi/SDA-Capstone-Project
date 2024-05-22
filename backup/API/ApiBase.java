package sda.capstone.API;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import sda.capstone.ActionsBot;
import sda.capstone.API.utilities.Authentication;


public abstract class ApiBase {
    public static Logger logger;
    public RequestSpecification spec;

    @BeforeMethod
    @Parameters({"username","password"})
    public void beforeMethod(String username,String password){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(ApiBase.class.getName());
        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+Authentication.generateToken(username,password))
                .build();
    }
}