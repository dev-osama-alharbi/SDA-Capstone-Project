package sda.capstone;

import sda.capstone.Pages.AddTeamPage;
import sda.capstone.Pages.TeamsPage;
import sda.capstone.TestBase;
import sda.capstone.Pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DisplayAndAddTeamInTeamModule extends TestBase {

    private final By loginButton = By.className("login-button");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By signinButton = By.xpath("//button[@type='submit']");

    TeamsPage teams;
    AddTeamPage addTeam;



    @Step("Given I am on the Teams page")
    @Test(testName = "Verify team is displayed and clickable")
    public void displayedAndClickableTeamsTest() {
        bot.navigate("https://qa-gm3.quaspareparts.com/");

        bot.click(loginButton);

        bot.type(usernameField, "testevolve12@testevolve.com");
        bot.type(passwordField, "DJK7wyf8_ZpG464");
        bot.click(signinButton);


        teams = new TeamsPage(driver, bot, wait)
                .navigateToTeamModule();


        boolean teamExist = teams.isTeamDisplayed();
        boolean isClickable = teams.isTeamClickable();

        Assert.assertTrue(teamExist, "Team element is not displayed");
        Assert.assertTrue(isClickable, "Team element is not clickable");
    }


    @Step("Given I am on the on the add team page")
    @Test(testName = "Add a new team with filled requirements")
    public void addTeamWithFilledRequirementsTest() {
        bot.navigate("https://qa-gm3.quaspareparts.com/");

        bot.click(loginButton);

        bot.type(usernameField, "testevolve12@testevolve.com");
        bot.type(passwordField, "DJK7wyf8_ZpG464");
        bot.click(signinButton);

        new TeamsPage(driver, bot, wait)
                .navigateToTeamModule();

        addTeam = new AddTeamPage(driver, bot, wait);
        String actualMsg = addTeam
                .addNewTeam()
                .enterDepartmentName()
                .enterDepartmentType()
                .clickSave()
                .getSuccessMessage();

        Assert.assertEquals(actualMsg, "New department successfully created");
    }


    @Step("Given I am on the on the add team page")
    @Test(testName = "Add a new team with empty requirements")
    public void addTeamWithEmptyRequirementsTest() {
        bot.navigate("https://qa-gm3.quaspareparts.com/");

        bot.click(loginButton);

        bot.type(usernameField, "testevolve12@testevolve.com");
        bot.type(passwordField, "DJK7wyf8_ZpG464");
        bot.click(signinButton);

        new TeamsPage(driver, bot, wait)
                .navigateToTeamModule();

        addTeam = new AddTeamPage(driver, bot, wait);
        String actualRequiredNameErrMsg = addTeam
                .addNewTeam()
                .leaveDepartmentNameEmpty()
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

