package sda.capstone.UI.us0014;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.EditTeamPage;
import sda.capstone.Pages.StartPage;
import sda.capstone.Pages.TeamsPage;
import sda.capstone.TestBase;

public class EditAndDeleteTeam extends TestBase {
    StartPage startPage;
    TeamsPage teams;
    EditTeamPage editTeam;

    @Step("Given I am on the on the Teams page")
    @Test(testName = "Edit a team with filled required field", priority = 1)
    public void editTeamWithFilledRequiredField() {
        startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);
        teams = new TeamsPage(driver, bot, wait);

        boolean isTeamToEditExist = teams.navigateToTeamModule().isTeamExist();
        Assert.assertTrue(isTeamToEditExist, "Team to select does not exist");

        teams.selectTeam();
        String actualSuccessMsg = new EditTeamPage(driver, bot, wait)
                .clickEditTeam()
                .editTeamName()
                .editShortTeamName()
                .editDescription()
                .addRole()
                .clickSave()
                .getSuccessMessage();

        Assert.assertEquals(actualSuccessMsg, "Changes successfully saved");
    }


    @Step("Given I am on the on the Teams page")
    @Test(testName = "Edit a team with empty required field", priority = 2)
    public void editTeamWithEmptyRequiredField() {
        startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);

        teams = new TeamsPage(driver, bot, wait);
        editTeam = new EditTeamPage(driver, bot, wait);

        boolean isTeamToEditExist = teams.navigateToTeamModule().isTeamExist();
        Assert.assertTrue(isTeamToEditExist, "Team to select does not exist");

        teams.selectTeam();
        String actualRequiredNameErrMsg = editTeam
                .clickEditTeam()
                .editShortTeamName()
                .editDescription()
                .clearTeamName()
                .clickSave()
                .getRequiredFieldMsg();
        Assert.assertEquals(actualRequiredNameErrMsg, "Please enter a name for department");

        String actualRequiredTypeErrMsg = editTeam
                .editTeamName()
                .clearTeamType()
                .clickSave()
                .getRequiredFieldMsg();
        Assert.assertEquals(actualRequiredTypeErrMsg, "Please select a type for department");
    }


    @Step("Given I am on the on the edit team page")
    @Test(testName = "Delete selected team", priority = 3)
    public void deleteTeam() {
        startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);
        teams = new TeamsPage(driver, bot, wait);

        boolean isTeamToDeleteExist = teams.navigateToTeamModule().isTeamExist();
        Assert.assertTrue(isTeamToDeleteExist, "Team to select does not exist");

        teams.selectTeam();
        editTeam = new EditTeamPage(driver, bot, wait)
                .clickEditTeam()
                .deleteTeam()
                .confirmDeleteTeam();

        teams.navigateToTeamModule();

        boolean isTeamDeletedExist = teams.isTeamExist();
        Assert.assertFalse(isTeamDeletedExist);
    }
}


