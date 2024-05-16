package sda.capstone.UI.us0013;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


public class DisplayAndAddTeamInTeamModule extends UITestBase {
    StartPage startPage;
    TeamsPage teams;
    AddTeamPage addTeam;


    @Step("Given I am on the Teams page")
    @Test(testName = "Verify teams are displayed and clickable")
    public void displayedAndClickableTeamsTest() {
        startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);

        teams = new TeamsPage(driver, bot, wait);
        teams.navigateToTeamModule();

        Assert.assertFalse(teams.getTeamElements().isEmpty());
        System.out.println("teamSize = " + teams.getTeamElements().size());

        for (WebElement team : teams.getTeamElements()) {
            String attributeValue = team.getAttribute("textContent");
            System.out.println(attributeValue);
        }

        boolean isTeamDisplayed = teams.isTeamDisplayed();
        boolean isClickable = teams.isTeamClickable();

        Assert.assertTrue(isTeamDisplayed, "Teams are not displayed");
        Assert.assertTrue(isClickable, "Teams are not clickable");

    }


    @Step("Given I am on the on the add team page")
    @Test(testName = "Add a new team with filled requirements")
    public void addTeamWithFilledRequirementsTest() {
        startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);

        new TeamsPage(driver, bot, wait).navigateToTeamModule().addNewTeam();

        addTeam = new AddTeamPage(driver, bot, wait);
        String actualMsg = addTeam
                .enterDepartmentName()
                .enterShortDepartmentName()
                .enterDescription()
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
        startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);

        new TeamsPage(driver, bot, wait).navigateToTeamModule().addNewTeam();

        addTeam = new AddTeamPage(driver, bot, wait);
        String actualRequiredNameErrMsg = addTeam
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

