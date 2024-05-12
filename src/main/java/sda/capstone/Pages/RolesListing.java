package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;




public class RolesListing extends PageBase {

    private final By rolesLocator = By.xpath("(//div[@class='row'])[4]");
    private final By roleElementLocator = By.xpath("//div[@class='row mb-0']");

    public RolesListing(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public List<String> getAllRoles() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/roles");

        wait.until(ExpectedConditions.visibilityOfElementLocated(roleElementLocator));

        List<WebElement> roleElements = driver.findElements(roleElementLocator);
        List<String> roles = new ArrayList<>();

        for (WebElement roleElement : roleElements) {
            roles.add(roleElement.getText());
        }

        return roles;
    }

    @Step("List Roles")
    public String listRoles() {
        return bot.getText(rolesLocator);
    }
}