package sda.capstone.US_0011;

import Pages.NewRemoteUnitPage;
import Pages.RemoteUnitsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import sda.capstone.Pages.*;
import org.testng.annotations.Test;
import sda.capstone.TestBase;

public class AddNewRemoteUnitsTest extends TestBase {
    private RemoteUnitsPage remoteUnitPage;
    private NewRemoteUnitPage newRemoteUnitPage;


    @Step("When adding a new remote unit by typing the name and type, it is added successful")
    @Test(testName = "Successful add new remote unit test")
    public void addNewRemoteUnitByTypingTheNameAndTypeTest() {
        //https://qa-gm3.quaspareparts.com/
        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        //https://a3m-qa-gm3.quaspareparts.com/login
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitsPage(driver,bot,wait);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();
        newRemoteUnitPage = new NewRemoteUnitPage(driver,bot,wait);
        newRemoteUnitPage.addRemoteName("Team4Test").addRemoteType("Remote Unit").clickingOnSaveButton();
        String actualText = newRemoteUnitPage.successfullyMSG();
        Assert.assertEquals(actualText, "New department successfully created");

    }


    @Step("When adding a new remote unit by typing the type and without name , I will see an error message")
    @Test(testName = "Unsuccessful add new remote unit test - Empty name ")
    public void addNewRemoteUnitWithoutAddNameTest() {
        //https://qa-gm3.quaspareparts.com/
        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        //https://a3m-qa-gm3.quaspareparts.com/login
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitsPage(driver,bot,wait);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();
        newRemoteUnitPage = new NewRemoteUnitPage(driver,bot,wait);
        newRemoteUnitPage.addRemoteName(null).addRemoteType("remote").clickingOnSaveButton();
        String actualText = newRemoteUnitPage.errorMSG();
        Assert.assertEquals(actualText, "Please enter a name for department");
    }

    @Step("When adding a new remote unit by typing the name and without type , I will see an error message")
    @Test(testName = "Unsuccessful add new remote unit test - Empty type ")
    public void addNewRemoteUnitWithoutAddTypeTest() {
        //https://qa-gm3.quaspareparts.com/
        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        //https://a3m-qa-gm3.quaspareparts.com/login
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnitsPage(driver,bot,wait);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();
        newRemoteUnitPage = new NewRemoteUnitPage(driver,bot,wait);
        newRemoteUnitPage.addRemoteName("Team4").addRemoteType(null).clickingOnSaveButton();
        String actualText = newRemoteUnitPage.errorMSG();
        Assert.assertEquals(actualText, "Please select a type for department");
    }
}
