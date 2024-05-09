package Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

import java.time.Duration;

//Displays the departments registered in the Departments module and lists their authorized roles
public class PermissionsListing extends PageBase {

    private final By Permissions = By.xpath("(//div[@class='row'])[5]");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public PermissionsListing(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    private void WaitFor(By by) {
        boolean displayed = false;
        do {
            try {
                Thread.sleep(3000);
                displayed = driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException noSuchElementException) {
                driver.navigate().refresh();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!displayed);
    }

    @Step("List Permissions")
    public String ListPermissions() {
        return bot.getText(Permissions);

    }
}

