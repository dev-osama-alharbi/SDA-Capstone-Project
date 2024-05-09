package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class Users extends PageBase {

    private final By addNewMemberButton = By.xpath("//button[text()='+ Add New Member']");
    private final By departmentDropdownLocator = By.cssSelector("#react-select-2-input");  //
    private final By roleDropdownLocator = By.cssSelector("#react-select-3-input");  //
    private final By emailInputFieldLocator = By.name("email");
    private final By registerButtonLocator = By.cssSelector("button[type='button']");  //

    private final By successMessage = By.cssSelector("div.toast-body");
    private final By errorMessage = By.xpath("//span[text()='Please enter a valid email' and @class='text-danger']");
    protected Wait<WebDriver> wait;

    public Users(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("When I navigate to the Users module and attempt to add a new user with a valid email")
    public Users ClickOnAddNewMember () {
        bot.click(addNewMemberButton);
        return this;
    }

    @Step("Clicking on Department name and selecting 'sda'")
    public Users selectDepartment(String departmentName) {
        bot.click(departmentDropdownLocator);

        return this;
    }

    @Step("Clicking on Department name ")
    public Users ClickOnDepartmentName () {
        // This method can be removed
        bot.click(departmentDropdownLocator);
        return this;
    }

    @Step("Clicking on Role")
    public Users ClickOnRole () {
        bot.click(roleDropdownLocator);
        return this;
    }

    @Step("Clicking on Email")
    public Users ClickOnEmail() {
        bot.click(emailInputFieldLocator);
        return this;
    }

    @Step("Entering the Email")
    public Users enterEmail(String email) {
        bot.type(emailInputFieldLocator, email);
        return this;
    }

    @Step("Clicking on Register")
    public Users ClickOnRegister () {
        bot.click(registerButtonLocator);
        return this;
    }

    @Step("Getting the Successful message")
    public String GetTheSucess () {
        return bot.getText(successMessage);
    }

    @Step("Getting the invalid message")
    public String GetTheError () {
        return bot.getText(errorMessage);
    }
}
