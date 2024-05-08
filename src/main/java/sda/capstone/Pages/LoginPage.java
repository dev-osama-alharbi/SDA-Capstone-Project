package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class LoginPage extends PageBase {
    public By usernameInput = By.id("username");
    public By passwordInput = By.id("password");
    public By submitButton = By.xpath("//button[@type='submit']");
    public String loginPageUrl = "https://a3m-qa-gm3.quaspareparts.com/login";
    public By invalidCredentialsMessage = By.tagName("h5");
    public By validLogin = By.xpath("//h4[contains(text(), 'Profile')]");


    public LoginPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait){
        super(driver,bot,wait);
    }
//    public Login(WebDriver driver, ActionsBot bot) {
//        super(driver, bot);
//    }

    public LoginPage goTo(){
        bot.navigate(loginPageUrl);
        return this;
    }

    @Step ("And perform the login action")
    public LoginPage login(String usernameValue, String passwordValue) {
        bot.type(usernameInput, usernameValue);
        bot.type(passwordInput, passwordValue);
        bot.click(submitButton);
        return this;
    }

    @Step ("Then I will Login successfully")
    public String validLogin() {
        wait.until(f -> {
            driver.findElement(validLogin).isDisplayed();
            return true;
        });
        return bot.getText(validLogin);
    }
    @Step ("Then I will see an error message")
    public String getInvalidCredentialsMessage() {
        return bot.getText(invalidCredentialsMessage);
    }
}
