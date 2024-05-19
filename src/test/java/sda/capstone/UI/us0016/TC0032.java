package sda.capstone.UI.us0016;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;
import sda.capstone.UI.UITestBase;

public class TC0032 extends UITestBase {

    @Test(testName = "TC_0032: Reset Password")
    @Step("US_0016: Edit the users displayed in the Users module")
    public void TC0032 () {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        navigateToUsersModule();
        navigateToUsers();
        resetPassword();
    }

    @Step("Navigate to Users module")
    public void navigateToUsersModule() {
        bot.click(By.xpath("//a[@href='#/users']"));
    }
    @Step("Navigate to Users")
    public void navigateToUsers() {

        wait.until(webDriver -> driver.findElement(By.xpath("//a[@href='#/user/1722' and contains(text(),'New UserName for Team4')]")).isDisplayed());
        bot.click(By.xpath("//a[@href='#/user/1722' and contains(text(),'New UserName for Team4')]"));

        wait.until(webDriver -> driver.findElement(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']")).isDisplayed());
        bot.click(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"));

        bot.type(By.id("username"),"New UserName for Team4 and 4"+ Keys.ENTER);

        wait.until(webDriver -> driver.findElement(By.cssSelector("button.btn.btn-ghost-primary.rounded-circle")).isDisplayed());
        bot.click(By.cssSelector("button.btn.btn-ghost-primary.rounded-circle"));

        wait.until(webDriver -> driver.findElement(By.xpath("//img[contains(@class, 'ms-2') and contains(@class, 'cursor-pointer')]")).isDisplayed());
        bot.click(By.xpath("//img[contains(@class, 'ms-2') and contains(@class, 'cursor-pointer')]"));

        bot.type(By.id("react-select-3-input"),"Customer"+Keys.ENTER);

        bot.click(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-info') and contains(@class, 'float-end') and contains(@class, 'text-white') and text()='Save']"));

    }

    @Step("Reset Password")
    public void resetPassword() {

        wait.until(webDriver -> driver.findElement(By.xpath("//a[@href='#/user/1722' and contains(text(),'Azduan-16@msn.com')]")).isDisplayed());

        bot.click(By.xpath("//a[@href='#/user/1722' and contains(text(),'Azduan-16@msn.com')]"));
        bot.click(By.id("changePasswordButton"));
        bot.click(By.xpath("//div[@class='modal-content']//button[@class='btn btn-dark text-white me-2'][text()='Confirm']"));

    }
}
