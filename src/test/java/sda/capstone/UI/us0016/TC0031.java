package sda.capstone.UI.us0016;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class TC0031 extends UITestBase {

    @Test(testName = "TC_0031: Edit the users displayed in the Users module.")
    @Step("US_0016: Edit the users displayed in the Users module")
    public void TC0031 () {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        navigateToUsersModule();
        navigateToUsers();
    }

    @Step("Navigate to Users module")
    public void navigateToUsersModule() {
        bot.click(By.xpath("//a[@href='#/users']"));
    }
    @Step("Navigate to Users")
    public void navigateToUsers() {

        wait.until(webDriver -> driver.findElement(By.xpath("//a[@href='#/user/66' and contains(text(),'New UserNameNew Team4')]")).isDisplayed());
        bot.click(By.xpath("//a[@href='#/user/66' and contains(text(),'New UserNameNew Team4')]"));

        wait.until(webDriver -> driver.findElement(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']")).isDisplayed());
        bot.click(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"));

        bot.type(By.id("username"),"Team4"+ Keys.ENTER);

        wait.until(webDriver -> driver.findElement(By.cssSelector("button.btn.btn-ghost-primary.rounded-circle")).isDisplayed());
        bot.click(By.cssSelector("button.btn.btn-ghost-primary.rounded-circle"));

        wait.until(webDriver -> driver.findElement(By.xpath("//img[contains(@class, 'ms-2') and contains(@class, 'cursor-pointer')]")).isDisplayed());
        bot.click(By.xpath("//img[contains(@class, 'ms-2') and contains(@class, 'cursor-pointer')]"));

        bot.type(By.id("react-select-3-input"),"Customer"+Keys.ENTER);

        bot.click(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-info') and contains(@class, 'float-end') and contains(@class, 'text-white') and text()='Save']"));

    }


}
