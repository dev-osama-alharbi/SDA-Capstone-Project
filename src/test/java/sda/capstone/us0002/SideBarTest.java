package sda.capstone.us0002;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;
import sda.capstone.listener.CustomListener;

@Listeners(CustomListener.class)
public class SideBarTest extends TestBase {

    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";

    @Step("Verifies the visibility of the side bar on the home page")
    @Test(testName = "Verifies the visibility of the side bar on the home page.")
    public void sidBarTest(){
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        Assert.assertTrue(homePage.checkTheVisibilityOfTheSideBar());
    }
}
