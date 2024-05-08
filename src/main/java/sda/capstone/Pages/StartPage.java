package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class StartPage extends PageBase {
    public String StartPageUrl = "https://qa-gm3.quaspareparts.com/";
    public By loginButton = By.className("login-button");

    public By loginPageUrl=By.tagName("h4");

    public StartPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait){
        super(driver,bot,wait);
    }

    @Step("Given I am on the Start page")
    public StartPage goTo(){
        bot.navigate(StartPageUrl);
        return this;
    }

    @Step ("When I click the login button, I will be directed to the Login page")
    public LoginPage clickLoginButton(){
        bot.click(loginButton);
        bot.getText(loginPageUrl);
        return new LoginPage(driver,bot,wait);
    }
}
