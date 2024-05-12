package sda.capstone.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


public class CustomListener implements ITestListener, WebDriverListener {

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " FAILED");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " PASSED");
    }

    @Step("Capturing screenshot evidence after get the text from an element")
    public void afterGetText(WebElement element, String result) {
        try (InputStream is = Files.newInputStream(element.getScreenshotAs(OutputType.FILE).toPath())) {
            Allure.attachment("image.png", is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Step("Capturing screenshot evidence after clicking an element")
//    public void beforeClick(WebElement element) {
//        try (InputStream is = Files.newInputStream(element.getScreenshotAs(OutputType.FILE).toPath())) {
//                Allure.attachment("image.png", is);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    public String capturingScreenshotEvidence(By parentBy, By evidenceBy) {
//        WebElement parentElement = driver.findElement(parentBy);
//        WebElement evidenceElement = managerSlmService.driver.findElement(evidenceBy);
//        // To highlight the element
//        ((JavascriptExecutor) managerSlmService.driver).executeScript("arguments[0].style.border='2px solid red'", evidenceElement);
//        String img = parentElement.getScreenshotAs(OutputType.BASE64);
//        // To remove border from highlighted element(Optional)
//        ((JavascriptExecutor) managerSlmService.driver).executeScript("arguments[0].style.border = \"none\";", evidenceElement);
//        return img;
//    }
}