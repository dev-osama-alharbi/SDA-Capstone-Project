package sda.capstone;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;


@Listeners(CustomListener.class)
public class loginTest extends TestBase {

    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";
    public String accountManagementPageUrl = "https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20";
    public String invalidCredentialsMessageText = "Invalid Credentials";
    public String profileTxt = "My Profile";

    public String invalidPassword = "WrongPassword";


    @Step("When I Login with the right Credentials, then I will login successfully")
    @Test(testName = "Successful LogIn Test")
    public void successfulLoginTest() {
        StartPage startPage = new StartPage(driver,bot,wait);
        LoginPage loginPage = startPage.goTo().clickLoginButton().login(username,password);
        Assert.assertEquals(loginPage.validLogin(),profileTxt);
    }


    @Step("When I Login with wrong password, I will see an error message")
    @Test(testName = "Unsuccessful LogIn Test - Invalid password")
    public void unsuccessfulLoginTest_InvalidCredentialWithoutDot() {
        StartPage startPage = new StartPage(driver,bot,wait);
        LoginPage loginPage = startPage.goTo().clickLoginButton().login(username, invalidPassword);
        Assert.assertNotEquals(driver.getCurrentUrl(), accountManagementPageUrl);
        Assert.assertEquals(loginPage.getInvalidCredentialsMessage(), invalidCredentialsMessageText);
    }

    @Step("When I Login with the wrong username, I will see an error message")
    @Test(dataProvider = "invalidUsernames", testName = "Unsuccessful LogIn Test - Invalid usernames ")
    public void unsuccessfulLoginTest_InvalidCredentialWithoutAt(String username) {
        StartPage startPage = new StartPage(driver,bot,wait);
        LoginPage loginPage = startPage.goTo().clickLoginButton().login(username, password);
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