package sda.capstone;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class ActionsBot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final Logger logger;

    public ActionsBot(WebDriver driver, Wait<WebDriver> wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    @Step
    public void navigate(String url){
        logger.info("Navigating to: "+url);
        driver.get(url);
    }

    @Step
    public void type(By locator, CharSequence text){
        logger.info("Typing: "+text+", into: "+locator);
        wait.until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    @Step
    public void click(By locator){
        logger.info("Clicking: "+locator);
        wait.until(f -> {
            try {
                logger.debug("Using Native Selenium Click");
                driver.findElement(locator).click();
            } catch (ElementClickInterceptedException exception){
                logger.debug("Using JavaScript Click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
            }
            return true;
        });
    }

    @Step
    public void dragAndDrop(By fBy, By sBy) {
        logger.info("dragAndDrop: "+fBy+" to "+sBy);
        new Actions(driver)
                .dragAndDrop(driver.findElement(fBy),driver.findElement(sBy))
                .build()
                .perform();
    }

    @Step
    public String getText(By by) {
        logger.info("getText: "+by);
        return driver.findElement(by).getText();
    }

}
