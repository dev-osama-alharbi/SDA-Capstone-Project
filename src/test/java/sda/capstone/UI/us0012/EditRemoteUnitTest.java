package sda.capstone.UI.us0012;


import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class EditRemoteUnitTest extends UITestBase {
    private RemoteUnitPage remoteUnitPage;
    private EditRemoteUnitPage EditRemoteUnitPage;

    private StartPage startPage;
    private HomePage homePage;



    @Step("When edit a remote unit by typing the name and type, it is edited successful")
    @Test(testName = "Successful edit remote unit test")
    public void editRemoteUnitByTypingTheNameAndTypeTest() {
        startPage = new StartPage(driver,bot,wait);
        homePage = startPage.goTo().clickLoginButton().login(username,password);


        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver,bot,wait);
        remoteUnitPage.goTo().selectARemoteUnitToEdit().clickEditRemoteUnitButton();

        EditRemoteUnitPage = new EditRemoteUnitPage(driver,bot,wait);
        EditRemoteUnitPage.editRemoteName("Edit Test 4").editRemoteType("Team").clickingOnSaveButton();

        Assert.assertEquals( EditRemoteUnitPage.successfullyMSG(), "Changes successfully saved");

    }

    @Step("When edit a remote unit by typing  type without name,  I will see an error message")
    @Test(testName = "Unsuccessful edit remote unit test - Empty name")
    public void editRemoteUnitWithoutAddNameTest() {
        startPage = new StartPage(driver,bot,wait);
        homePage = startPage.goTo().clickLoginButton().login(username,password);


        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver,bot,wait);
        remoteUnitPage.goTo().selectARemoteUnitToEdit().clickEditRemoteUnitButton();

        EditRemoteUnitPage = new EditRemoteUnitPage(driver,bot,wait);
        EditRemoteUnitPage.editRemoteName(null).editRemoteType("Team").clickingOnSaveButton();

        Assert.assertEquals( EditRemoteUnitPage.errorMSG(),"Please enter a name for department");
    }

    @Step("When edit a remote unit by typing the name and without type , I will see an error message")
    @Test(testName = "Unsuccessful edit remote unit test - Empty type ")
    public void editRemoteUnitWithoutATypeTest() {

        startPage = new StartPage(driver,bot,wait);
        homePage = startPage.goTo().clickLoginButton().login(username,password);


        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver,bot,wait);
        remoteUnitPage.goTo().selectARemoteUnitToEdit().clickEditRemoteUnitButton();

        EditRemoteUnitPage = new EditRemoteUnitPage(driver,bot,wait);
        EditRemoteUnitPage.editRemoteName("Testdep").editRemoteType(null).clickingOnSaveButton();

        Assert.assertEquals( EditRemoteUnitPage.errorMSG(),"Please select a type for department");

    }

    @Step(" ")
    @Test
    public void deleteRemoteUnitTest() {

        startPage = new StartPage(driver, bot, wait);
        homePage = startPage.goTo().clickLoginButton().login(username, password);


        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver, bot, wait);
        remoteUnitPage.goTo().selectARemoteUnitToEdit().clickEditRemoteUnitButton();
        EditRemoteUnitPage = new EditRemoteUnitPage(driver,bot,wait);

    }

}
