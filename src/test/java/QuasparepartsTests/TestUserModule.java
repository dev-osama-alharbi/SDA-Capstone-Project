package QuasparepartsTests;

import Pages.UserPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.TestBase;

import java.util.List;

public class TestUserModule extends TestBase {

    @Step("TC_0029 Displays users in the Users module ")
    @Test
    public void DisplaysUsers () {

        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        navigateToUsersModule();
        validateUsersDisplayed();
    }

    @Step("Navigate to Users module")
    public void navigateToUsersModule() {
        // Implementation might vary; assuming clicking a specific link
        bot.click(By.xpath("//a[@href='#/users']"));
    }

    @Step("Validate users list is displayed")
    public void validateUsersDisplayed() {
//        List<WebElement> users;
//        users = bot.findElements(By.xpath("//tbody[@class='tableRows']//tr//td[2]//a"));
        UserPage userPage = new UserPage(driver,bot,wait);
        List<String> users = userPage.getUsers();
        Assert.assertTrue(users.size() > 0, "No users are displayed.");
        users.forEach(System.out::println);
    }









}
