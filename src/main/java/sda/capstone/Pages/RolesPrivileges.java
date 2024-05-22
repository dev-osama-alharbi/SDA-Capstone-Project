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
public class RolesPrivileges extends PageBase {

    private final By BusinessOwnerSelector = By.xpath("//a[@href='#/role/5']");
    private final By ListPrivileges = By.xpath("//label[@for='permissions']");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public RolesPrivileges(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
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

    @Step("Clicking on Role 'Business Owner'")
    public RolesPrivileges ClickOnBusinessOwner() {
        bot.click(BusinessOwnerSelector);

        return this;
    }
    @Step("List Privileges")
    public String ListPrivileges() {
        wait.until(f -> {
            driver.findElement(ListPrivileges).isDisplayed();
            return true;
        });
        return bot.getText(ListPrivileges);

    }
}

