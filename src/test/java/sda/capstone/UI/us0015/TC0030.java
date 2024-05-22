package sda.capstone.UI.us0015;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;
import sda.capstone.UI.UITestBase;

public class TC0030 extends UITestBase {
    @Test(testName = "TC_0030: checking the verified emails")
    @Step("US_0015: Displays users in the Users module.")
    public void TC0030 () {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        navigateToUsersModule();
        checkingTheVerifiedUsers();
    }

    @Step("Navigate to Users module")
    public void navigateToUsersModule() {

        bot.click(By.xpath("//a[@href='#/users']"));
    }

    @Step("Displays users in the Users module.")
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
