package sda.capstone.UI.us0003;

import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class DropdownFunctionalityTest extends UITestBase {


    @Test(testName = "Verify the functions of the drop-down menu")
    public void displayOfTheDropDownTest(){
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        homePage.checkSuccessfulLogin();
        homePage.clickOnUserPhoto();
//        Assert.assertTrue(driver.findElement(dropDown).isDisplayed());
        Assert.assertTrue(homePage.dropDownIsDisplayed());
    }

    @Test(testName = "Verify the functions of the drop-down menu which displaying the username")
    public void displayUsernameInDropDownTest(){
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        homePage.checkSuccessfulLogin();
        Assert.assertTrue(homePage.getTheUsernameTextFromTheDropdown());
    }

    @Test(testName = "Verify the functions of the drop-down menu which displaying the user's role")
    public void displayTheRoleInDropDownTest(){
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        homePage.checkSuccessfulLogin();
        Assert.assertTrue(homePage.getTheRoleTextFromTheDropdown());
    }
}
