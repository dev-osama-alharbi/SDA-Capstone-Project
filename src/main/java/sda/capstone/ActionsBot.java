package sda.capstone;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
        wait.until(f -> driver.findElement(by).isDisplayed());
        return driver.findElement(by).getText();
    }

    @Step("Check the element is displayed")
    public boolean isDisplayed(By by) {
        logger.info("Check the element is displayed from: " + by);
        wait.until(f -> driver.findElement(by).isDisplayed());
        return driver.findElement(by).isDisplayed();
    }

    public void waitUntilIsNotDisplayed(By by) {
        logger.info("Check and wait the element is not displayed from: " + by);
        wait.until(f -> driver.findElements(by).isEmpty());
    }

    @Step("Get tag name from element")
    public String getTagName(By by) {
        logger.info("Getting Tag name from: " + by);
        wait.until(f -> driver.findElement(by).isDisplayed());
        return driver.findElement(by).getTagName();
    }

    @Step
    public List<String> getTextList(By by) {
        logger.info("getText: "+by);
        return driver.findElements(by).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

    @Step("Capturing Screenshot Evidence")
    public void capturingScreenshotEvidence(By parentBy,By evidenceBy) {
        wait.until(driver1 -> driver1.findElement(parentBy).isDisplayed() && driver1.findElement(evidenceBy).isDisplayed());
        WebElement parentElement = driver.findElement(parentBy);
        WebElement evidenceElement = driver.findElement(evidenceBy);

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", evidenceElement);

        try (InputStream is = Files.newInputStream(parentElement.getScreenshotAs(OutputType.FILE).toPath())) {
            Allure.attachment("image.png", is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = \"none\";", evidenceElement);

    }

    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }
}
