package sda.capstone.UI.us0011;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class AddNewRemoteUnitsTest extends UITestBase {
    private RemoteUnitPage remoteUnitPage;
    private NewRemoteUnitPage newRemoteUnitPage;
    private StartPage startPage;
    private LoginPage loginPage;

    @Step("When adding a new remote unit by typing the name and type, it is added successful")
    @Test(testName = "Successful add new remote unit test")
    public void addNewRemoteUnitByTypingTheNameAndTypeTest() {

         startPage = new StartPage(driver,bot,wait);
         startPage.goTo().clickLoginButton().login(username,password);



        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver,bot,wait);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();
        newRemoteUnitPage = new NewRemoteUnitPage(driver,bot,wait);
        newRemoteUnitPage.addRemoteName("TeamTest").selectDepartmentType("Remote Unit").clickingOnSaveButton();
        String actualText = newRemoteUnitPage.successfullyMSG();
        Assert.assertEquals(actualText, "New department successfully created");

    }


    @Step("When adding a new remote unit by typing the type and without name , I will see an error message")
    @Test(testName = "Unsuccessful add new remote unit test - Empty name ")
    public void addNewRemoteUnitWithoutAddNameTest() {

        startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);


        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver,bot,wait);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();
        newRemoteUnitPage = new NewRemoteUnitPage(driver,bot,wait);
        newRemoteUnitPage.selectDepartmentType("Remote Unit").clickingOnSaveButton();
        String actualText = newRemoteUnitPage.errorMSG();
        Assert.assertEquals(actualText, "Please enter a name for department");
    }

    @Step("When adding a new remote unit by typing the name and without type , I will see an error message")
    @Test(testName = "Unsuccessful add new remote unit test - Empty type ")
    public void addNewRemoteUnitWithoutAddTypeTest() {

        startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);


        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitPage(driver,bot,wait);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();
        newRemoteUnitPage = new NewRemoteUnitPage(driver,bot,wait);
        newRemoteUnitPage.addRemoteName("Team4").clickingOnSaveButton();
        String actualText = newRemoteUnitPage.errorMSG();
        Assert.assertEquals(actualText, "Please select a type for department");
    }




}
