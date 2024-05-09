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
    private final By addNewTeamElement = By.cssSelector("div>div>div>a>button");
    private final By departmentNameField = By.id("name");
    private final By shortDepartmentNameField = By.name("short_name");
    private final By departmentTypeField = By.id("react-select-2-input");
    private final By rolesInput = By.id("react-select-3-input");
    private final By saveButton = By.xpath("//button[text()='Save']");
    private final By messageElement = By.xpath("//div[@class='toast-body']");
    private final By requiredFieldMsg = By.xpath("//span[@class='text-danger']");
    private final String teamName = "SDA-Team4";

    public AddTeamPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("When I add new team")
    public AddTeamPage addNewTeam() {
        bot.click(addNewTeamElement);
        return this;
    }

    @Step("And enter department name")
    public AddTeamPage enterDepartmentName() {
        bot.type(departmentNameField, teamName);
        return this;
    }

    @Step("And enter department short name")
    public AddTeamPage enterShortDepartmentName(){
        bot.click(shortDepartmentNameField);
        bot.type(shortDepartmentNameField,"SDA-T4");
        return this;
    }

    @Step("And enter department type as Team")
    public AddTeamPage enterDepartmentType() {
        bot.click(departmentTypeField);
        bot.type(departmentTypeField, "Team" + Keys.ENTER);
        return this;
    }

    @Step("And enter department description")
    public AddTeamPage enterDescription(){
        bot.click(shortDepartmentNameField);
        bot.type(shortDepartmentNameField,"SDA-T4");
        return this;
    }

    @Step("And select roles")
    public AddTeamPage selectRole(){
        bot.type(rolesInput,"Quality Manager"+Keys.ENTER);
        return this;
    }

    @Step("And leave department name empty")
    public AddTeamPage leaveDepartmentNameEmpty() {
        driver.findElement(departmentNameField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(departmentNameField).sendKeys(Keys.DELETE);
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
        return bot.getText(requiredFieldMsg);
    }
}
