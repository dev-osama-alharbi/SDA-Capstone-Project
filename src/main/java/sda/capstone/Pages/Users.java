package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

import java.time.Duration;

public class Users extends PageBase {

    private final By addNewMemberButton = By.xpath("//button[text()='+ Add New Member']");
    //private final By DepartmentName = By.cssSelector(".card-test > div > div > a > b");
    private final By departmentDropdownLocator = By.cssSelector("#react-select-2-input");  //
    private final By roleDropdownLocator = By.cssSelector("#react-select-3-input");  //
    private final By emailInputFieldLocator = By.name("email");
    private final By registerButtonLocator = By.xpath("//button[text()='Register']");  //
    //private final By successMessage = By.cssSelector("#div.toast-body");
    private final By successMessage =  By.cssSelector(".me-auto");
    private final By errorMessage = By.xpath("//span[text()='Please enter a valid email']");
//    protected Wait<WebDriver> wait;


    public Users(WebDriver driver, ActionsBot bot,Wait<WebDriver> wait) {
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
        bot.type(departmentDropdownLocator,"TeamSDA4"+ Keys.ENTER);
        return this;
    }

    @Step("Clicking on Role")
    public Users ClickOnRole () {
        bot.click(roleDropdownLocator);
        bot.type(roleDropdownLocator,"B"+ Keys.ENTER);
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
        wait.until(driver1 -> driver1.findElement(successMessage).isDisplayed());
        return bot.getText(successMessage);
    }

    @Step("Getting the invalid message")
    public String GetTheError () {
        return bot.getText(errorMessage);
    }
}
