package sda.capstone.UI.us0015;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class TestUserModule extends UITestBase {

    @Step("Displays users in the Users module ")
    @Test
    public void DisplaysUsers () {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        navigateToUsersModule();
        newlyAddedUser();
        checkingTheVerifiedUsers();
    }

    @Step("Navigate to Users module")
    public void navigateToUsersModule() {

        bot.click(By.xpath("//a[@href='#/users']"));
    }

    @Step("TC_0029 Can see the newly added user")
    public void newlyAddedUser() {


        bot.click(By.xpath("//button[contains(text(),'+ Add New Member')]"));
        bot.type(By.id("react-select-2-input"),"Team4"+Keys.ENTER);
        bot.type(By.id("react-select-3-input"),"Business"+Keys.ENTER);
        bot.type(By.id("email"),"xyz@gmail.com");

        bot.click(By.xpath("//button[.='Register']"));
        wait.until(webDriver -> driver.findElement(By.cssSelector("div.toast-header.bg-success.text-white")).isDisplayed());

        String confirmationMessage = bot.getText(By.cssSelector("div.toast-header.bg-success.text-white"));
        Assert.assertTrue(confirmationMessage.contains("Successful"));

    }

    @Step("TC_0030 checking the verified emails")
    public void checkingTheVerifiedUsers() {

        wait.until(webDriver -> driver.findElement(By.cssSelector("td.cell svg path[fill='#08875D']")).isDisplayed());

        WebElement greenTick = driver.findElement(By.cssSelector("td.cell svg path[fill='#08875D']"));
        if (greenTick.isDisplayed()) {
            System.out.println("A green tick is displayed");
        } else {
            System.out.println("A green tick is not displayed");
        }
    }
}