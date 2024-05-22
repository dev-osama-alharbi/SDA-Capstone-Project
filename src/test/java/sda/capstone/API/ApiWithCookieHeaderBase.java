package sda.capstone.API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import sda.capstone.API.utilities.Authentication;

public class ApiWithCookieHeaderBase {
    public static Logger logger;
    public RequestSpecification spec;

    @BeforeClass
    public void setup() {
        String GSessionId = APIVars.read().getGSessionId();
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(ApiBase.class.getName());
        spec = new RequestSpecBuilder()
                .setBaseUri("https://qa-gm3.quaspareparts.com")
                .setContentType(ContentType.JSON)
//                .addHeader("Cookie", Authentication.generateGSessionId(username_ui, password_ui))
                .addHeader("Cookie", GSessionId)
                .build();
    }


    @BeforeSuite
    @Parameters({"username_ui", "password_ui"})
    public void BeforeSuite(String username_ui, String password_ui){
        APIVars.writeGSessionId(Authentication.generateGSessionId(username_ui, password_ui));
    }


    @AfterSuite
    public void afterSuite(){
        APIVars.writeGSessionId(null);
    }
}