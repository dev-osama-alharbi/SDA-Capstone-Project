package sda.capstone.us0001;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sda.capstone.Pages.*;
import sda.capstone.TestBase;
import sda.capstone.listener.CustomListener;


@Listeners(CustomListener.class)
public class LoginTest extends TestBase {

    public String username = "t4@testevolve.com";
    public String password = "ByDckIStx4Yet14";
    public String accountManagementPageUrl = "https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20";
    public String invalidCredentialsMessageText = "Invalid Credentials";
    public String profileTxt = "My Profile";
    public String invalidPassword = "WrongPassword";


    @Step("Login with the right Credentials")
    @Test(testName = "Successful LogIn Test")
    public void successfulLoginTest() {
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        Assert.assertEquals(homePage.checkSuccessfulLogin(),profileTxt);
    }

    @Step("Login with wrong password")
    @Test(testName = "Unsuccessful LogIn Test - Invalid password")
    public void unsuccessfulLoginTest_InvalidCredentialWithoutDot() {
        StartPage startPage = new StartPage(driver,bot,wait);
        LoginPage loginPage = startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,invalidPassword);
        Assert.assertNotEquals(driver.getCurrentUrl(), accountManagementPageUrl);
        Assert.assertEquals(loginPage.getInvalidCredentialsMessage(), invalidCredentialsMessageText);
    }

    @Step("Login with the wrong username")
    @Test(dataProvider = "invalidUsernames", testName = "Unsuccessful LogIn Test - Invalid usernames ")
    public void unsuccessfulLoginTest_InvalidCredentialWithoutAt(String username) {
        StartPage startPage = new StartPage(driver,bot,wait);
        LoginPage loginPage = startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        Assert.assertNotEquals(driver.getCurrentUrl(), accountManagementPageUrl);
        Assert.assertEquals(loginPage.getInvalidCredentialsMessage(), invalidCredentialsMessageText);
    }

    @DataProvider(name = "invalidUsernames")
    public Object[][] invalidEmails() {
        return new Object[][] {
                { "testevolve12testevolve.com" },
                { "testevolve12@testevolvecom" },
                { "testevolve12testevolvecom" }
        };
    }
}