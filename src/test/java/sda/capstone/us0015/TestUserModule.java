package sda.capstone.us0015;

import Pages.UserPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;

import java.util.List;

public class TestUserModule extends TestBase {

    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";

    @Step("TC_0029 Displays users in the Users module ")
    @Test
    public void DisplaysUsers () {

        //bot.navigate("https://qa-gm3.quaspareparts.com");
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        navigateToUsersModule();
        validateUsersDisplayed();
        checkingTheVerified();
    }

    @Step("Navigate to Users module")
    public void navigateToUsersModule() {
        // Implementation might vary; assuming clicking a specific link
        bot.click(By.xpath("//a[@href='#/users']"));
    }

    @Step("Validate users list is displayed")
    public void validateUsersDisplayed() {

        UserPage userPage = new UserPage(driver,bot,wait);
        List<String> users = userPage.getUsers();
        System.out.println("The list of users:");
        Assert.assertTrue(users.size() > 0, "No users are displayed.");
        users.forEach(System.out::println);
    }

    @Step("TC_0030 checking the verified emails ")
    @Test
    public void checkingTheVerified() {

        UserPage verifiedusers = new UserPage(driver,bot,wait);
        List<String> verified = verifiedusers.getverifiedusers();
        System.out.println("The list of verified users:");
        verified.forEach(System.out::println);
    }
}
