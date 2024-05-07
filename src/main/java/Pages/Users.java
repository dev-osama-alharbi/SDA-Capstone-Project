package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.capstone.ActionsBot;
import sda.capstone.Pages;

public class Users extends Pages {

    private final By addNewMemberButton = By.xpath("//button[text()='+ Add New Member']");
    private final By departmentDropdownLocator = By.cssSelector("#react-select-4-placeholder");  //
    private final By roleDropdownLocator = By.cssSelector("#react-select-5-placeholder");  //
    private final By emailInputFieldLocator = By.name("email");
    private final By registerButtonLocator = By.cssSelector("button[type='button']");  //

    private final By successMessage = By.cssSelector("strong.me-auto");
    private final By errorMessage = By.xpath("//span[text()='Please enter a valid email' and @class='text-danger']");
    protected Wait<WebDriver> wait;

    public Users(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("When I navigate to the Users module and attempt to add a new user with a valid email")
    public Users ClickOnAddNewMember () {
        bot.click(addNewMemberButton);
        return this;
    }




        @Step("Clicking on Department name ")
        public Users ClickOnDepartmentName () {
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
        @Step("Clicking on Register")
        public Users ClickOnRegister () {
            bot.click(registerButtonLocator);
            return this;
        }
        @Step("Getting the Successfual message")
        public Users GetTSucess () {
            bot.getText(successMessage);
            return this;
        }
        @Step("Getting the invaild message")
        public Users GetTheMessage () {
            bot.getText(errorMessage);
            return this;
        }
    }




