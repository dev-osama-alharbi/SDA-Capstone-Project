package sda.capstone.UI;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import sda.capstone.ActionsBot;
import sda.capstone.PropertiesReader;
import sda.capstone.listener.CustomListener;

import java.time.Duration;

public abstract class UITestBase {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    public static Logger logger;
    public ActionsBot bot;
    public String username;
    public String password;



    @Step("Initializing test data and properties")
    @BeforeSuite
    public static void beforeClass() {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(UITestBase.class.getName());

        PropertiesReader.readPropertyFile("src/main/resources/properties/configuration.properties");
    }

    @Step("Initializing target browser")
    @BeforeMethod
    @Parameters({"username","password"})
    public void beforeMethod(String username,String password){
        this.username = username;
        this.password = password;
        String targetBrowser = "chrome";

        logger.info("Opening Chrome Browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        switch (targetBrowser){
            case "chrome" -> driver = new ChromeDriver(chromeOptions);
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        driver = new EventFiringDecorator(new CustomListener()).decorate(driver);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        bot = new ActionsBot(driver, wait, logger);
    }

    @Step("Terminating target browser")
    @AfterMethod
    public void afterMethod(){
        logger.info("Quitting Browser");
        driver.quit();
    }
}