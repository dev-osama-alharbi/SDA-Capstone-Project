package sda.capstone.UI.us0002;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.listener.CustomListener;
import sda.capstone.Pages.*;

@Listeners(CustomListener.class)
public class SideBarTest extends UITestBase {


    @Step("Verifies the visibility of the side bar on the home page")
    @Test(testName = "Verifies the visibility of the side bar on the home page.")
    public void sidBarTest(){
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        Assert.assertTrue(homePage.checkTheVisibilityOfTheSideBar());
    }
}
