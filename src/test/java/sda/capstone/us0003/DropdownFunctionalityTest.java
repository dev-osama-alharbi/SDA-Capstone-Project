package sda.capstone.us0003;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;

public class DropdownFunctionalityTest extends TestBase {

    By dropDown = By.xpath("//ul[contains(@class, 'dropdown-menu')]");
    public String username = "t4@testevolve.com";
    public String password = "ByDckIStx4Yet14";

    @Test(testName = "Verify the functions of the drop-down menu")
    public void displayOfTheDropDownTest(){
        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().checkThedirectionToTheLoginPage().login(username,password);
        HomePage homePage = new HomePage(driver,bot,wait);
        homePage.checkSuccessfulLogin();
        homePage.clickOnUserPhoto();
        Assert.assertTrue(driver.findElement(dropDown).isDisplayed());
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
