package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class AddTeamPage extends PageBase {
    private final By departmentNameField = By.id("name");
    private final By shortDepartmentNameField = By.name("short_name");
    private final By departmentTypeField = By.id("react-select-2-input");
    private final By departmentDescriptionInput= By.xpath("//input[contains(@placeholder,'Department Description')]");
    private final By rolesInput = By.id("react-select-3-input");
    private final By saveButton = By.xpath("//button[text()='Save']");
    private final By messageElement = By.xpath("//div[@class='toast-body']");
    private final By requiredFieldMsg = By.xpath("//span[@class='text-danger']");

    public AddTeamPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }


    @Step("And enter department name")
    public AddTeamPage enterDepartmentName() {
        bot.type(departmentNameField, "SDA-Team4");
        return this;
    }

    @Step("And enter department short name")
    public AddTeamPage enterShortDepartmentName() {
        bot.click(shortDepartmentNameField);
        bot.type(shortDepartmentNameField, "SDA-T4");
        return this;
    }

    @Step("And enter department type as Team")
    public AddTeamPage enterDepartmentType() {
        bot.click(departmentTypeField);
        bot.type(departmentTypeField, "Team" + Keys.ENTER);
        return this;
    }

    @Step("And enter department description")
    public AddTeamPage enterDescription() {
        bot.click(departmentDescriptionInput);
        bot.type(departmentDescriptionInput, "Team 4 Description");
        return this;
    }

    @Step("And select roles")
    public AddTeamPage selectRole() {
        bot.type(rolesInput, "a"+Keys.ENTER);
        return this;
    }

    @Step("And leave department name empty")
    public AddTeamPage leaveDepartmentNameEmpty() {
        wait.until(f -> {
            driver.findElement(departmentNameField).clear();
            return true;
        });
        return this;
    }

    @Step("And leave department type empty")
    public AddTeamPage leaveDepartmentTypeEmpty() {
        bot.type(departmentTypeField, Keys.DELETE);
        return this;
    }

    @Step("And I click Save")
    public AddTeamPage clickSave() {
        bot.click(saveButton);
        return this;
    }

    @Step("Then success message is displayed")
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageElement)).getText();
    }

    @Step("Then required field message is displayed")
    public String getRequiredFieldMsg() {
        wait.until(f -> {
            driver.findElement(requiredFieldMsg).isDisplayed();
            return true;
        });
        return bot.getText(requiredFieldMsg);
    }
}
