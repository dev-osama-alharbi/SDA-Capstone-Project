package sda.capstone.us0013;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.AddTeamPage;
import sda.capstone.Pages.StartPage;
import sda.capstone.Pages.TeamsPage;
import sda.capstone.TestBase;


public class DisplayAndAddTeamInTeamModule extends TestBase {
    StartPage startPage;
    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";
    TeamsPage teams;
    AddTeamPage addTeam;


    @Step("Given I am on the Teams page")
    @Test(testName = "Verify team is displayed and clickable")
    public void displayedAndClickableTeamsTest() {
        startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        teams = new TeamsPage(driver, bot, wait).navigateToTeamModule();

        boolean isTeamDisplayed = teams.isTeamDisplayed();
        boolean isClickable = teams.isTeamClickable();

        Assert.assertTrue(isTeamDisplayed, "Team element is not displayed");
        Assert.assertTrue(isClickable, "Team element is not clickable");
    }


    @Step("Given I am on the on the add team page")
    @Test(testName = "Add a new team with filled requirements")
    public void addTeamWithFilledRequirementsTest() {
        startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        new TeamsPage(driver, bot, wait).navigateToTeamModule();

        addTeam = new AddTeamPage(driver, bot, wait);
        String actualMsg = addTeam
                .addNewTeam()
                .enterDepartmentName()
                .enterShortDepartmentName()
                .enterDepartmentType()
                .enterDescription()
                .selectRole()
                .clickSave()
                .getSuccessMessage();

        Assert.assertEquals(actualMsg, "New department successfully created");
    }


    @Step("Given I am on the on the add team page")
    @Test(testName = "Add a new team with empty requirements")
    public void addTeamWithEmptyRequirementsTest() {
        startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        new TeamsPage(driver, bot, wait).navigateToTeamModule();

        addTeam = new AddTeamPage(driver, bot, wait);
        String actualRequiredNameErrMsg = addTeam
                .addNewTeam()
                .leaveDepartmentNameEmpty()
                .enterShortDepartmentName()
                .enterDescription()
                .selectRole()
                .clickSave()
                .getRequiredFieldMsg();
        Assert.assertEquals(actualRequiredNameErrMsg, "Please enter a name for department");

        String actualRequiredTypeErrMsg = addTeam
                .enterDepartmentName()
                .leaveDepartmentTypeEmpty()
                .clickSave()
                .getRequiredFieldMsg();
        Assert.assertEquals(actualRequiredTypeErrMsg, "Please select a type for department");
    }

}

