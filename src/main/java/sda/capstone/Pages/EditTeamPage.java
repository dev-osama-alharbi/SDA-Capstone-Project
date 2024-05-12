package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class EditTeamPage extends PageBase {
    private final By editTeamButton = By.xpath("//button[contains(.,' Edit')]");
    private final By teamNameField = By.id("name");
    private final By shortTeamNameField = By.name("short_name");
    private final By teamTypeDropdown = By.id("react-select-2-input");
    private final By departmentDescriptionInput = By.xpath("//input[contains(@placeholder,'Department Description')]");
    private final By rolesInput = By.id("react-select-3-input");
    private final By saveButton = By.xpath("//button[text()='Save']");
    private final By messageElement = By.xpath("//div[@class='toast-body']");
    private final By requiredFieldMsg = By.xpath("//span[@class='text-danger']");
    private final By deleteDepartmentButton = By.xpath("//button[contains(@class,'btn btn-danger text-light')]");
    private final By confirmDeleteDepartmentButton = By.xpath("//button[text()='Confirm']");


    public EditTeamPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("And click on Edit Team")
    public EditTeamPage clickEditTeam() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editTeamButton));
        bot.click(editTeamButton);
        driver.navigate().refresh();
        return this;
    }

    @Step("And edit the team name")
    public EditTeamPage editTeamName() {
        clearTeamName();
        bot.type(teamNameField, "SDA-Team4");
        return this;
    }

    @Step("And edit the team short name")
    public EditTeamPage editShortTeamName() {
        bot.click(shortTeamNameField);
        bot.type(shortTeamNameField, Keys.CONTROL + "a");
        bot.type(shortTeamNameField, Keys.DELETE);

        bot.type(shortTeamNameField, "Edited SDAT4");
        return this;
    }

    @Step("And edit the team description")
    public EditTeamPage editDescription() {
        bot.type(departmentDescriptionInput, "Edited Description");
        return this;
    }

    @Step("And add a role")
    public EditTeamPage addRole() {
        bot.type(rolesInput, "a" + Keys.ENTER);
        return this;
    }

    @Step("And clear team name required field")
    public EditTeamPage clearTeamName() {
        wait.until(f -> {
            driver.findElement(teamNameField).sendKeys(Keys.CONTROL + "a");
            driver.findElement(teamNameField).sendKeys(Keys.DELETE);
            return true;
        });
        return this;
    }

    @Step("And clear team type required field")
    public EditTeamPage clearTeamType() {
        wait.until(f -> {
            driver.findElement(teamTypeDropdown).sendKeys(Keys.CONTROL + "a");
            driver.findElement(teamTypeDropdown).sendKeys(Keys.DELETE);
            return true;
        });
        return this;
    }

    @Step("And click save")
    public EditTeamPage clickSave() {
        bot.click(saveButton);
        return this;
    }

    @Step("Then I get the required field message")
    public String getRequiredFieldMsg() {
        wait.until(f -> {
            driver.findElement(requiredFieldMsg).isDisplayed();
            return true;
        });
        return bot.getText(requiredFieldMsg);
    }

    @Step("And click on Delete Department")
    public EditTeamPage deleteTeam() {
        bot.click(deleteDepartmentButton);
        return this;
    }

    @Step("And click on Confirm")
    public EditTeamPage confirmDeleteTeam() {
        wait.until(f -> {
            bot.click(confirmDeleteDepartmentButton);
            return true;
        });
        driver.navigate().refresh();
        return this;
    }

    @Step("Then I get the success message")
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageElement)).getText();
    }
}
