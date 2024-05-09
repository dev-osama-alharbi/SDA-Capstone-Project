package sda.capstone;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;


import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicReference;


public class ActionsBot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final Logger logger;

    public ActionsBot(WebDriver driver, Wait<WebDriver> wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    @Step("Navigate to URL")
    public void navigate(String url){
        logger.info("Navigating to: "+url);
        driver.get(url);
    }

    @Step("Type into element")
    public void type(By locator, CharSequence text){
        logger.info("Typing: "+text+", into: "+locator);
        wait.until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    @Step("Click on element")
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

    @Step("Get text from element")
    public String getText(By by) {
        logger.info("Getting text from: " + by);
        AtomicReference<String> actualText = new AtomicReference<>("");
        wait.until(f -> {
            actualText.set(driver.findElement(by).getText());
            return true;
        });
        return actualText.get();
    }

    @Step
    public List<String> getTextList(By by) {
        logger.info("getText: "+by);
        return driver.findElements(by).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step
    public List<String> getverifiedusers(By by) {
        logger.info("getText: "+by);
        return driver.findElements(by).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
