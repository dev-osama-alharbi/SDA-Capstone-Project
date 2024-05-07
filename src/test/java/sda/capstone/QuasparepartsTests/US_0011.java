package sda.capstone.QuasparepartsTests;

import Pages.NewRemoteUnit;
import Pages.RemoteUnits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.TestBase;

public class US_0011 extends TestBase {
    private  RemoteUnits  remoteUnitPage;
    private NewRemoteUnit newRemoteUnitPage;




    @Step("TC_0018 Positive Scenario when typing Name and Remote type ")
    @Test
    public void TC_0018 () {
        //https://qa-gm3.quaspareparts.com/
        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        //https://a3m-qa-gm3.quaspareparts.com/login
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnits(driver,bot);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();

        newRemoteUnitPage = new NewRemoteUnit(driver,bot);
        newRemoteUnitPage.addRemoteName("new").addRemoteType("Remote Unit").ClickingOnSaveButton();

        String actualText = newRemoteUnitPage.successfullyMSG();
        Assert.assertEquals(actualText, "New department successfully created");

    }


    @Step("TC_0019 Negative Scenario when Name empty")
    @Test
    public void TC_0019_NameEmpty () {
        //https://qa-gm3.quaspareparts.com/
        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        //https://a3m-qa-gm3.quaspareparts.com/login
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnits(driver,bot);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();

        newRemoteUnitPage = new NewRemoteUnit(driver,bot);
        newRemoteUnitPage.addRemoteName(null).addRemoteType("remote").ClickingOnSaveButton();

        String actualText = newRemoteUnitPage.ErrorMSGName();
        Assert.assertEquals(actualText, "Please enter a name for department");
    }

    @Step("TC_0019 Negative Scenario when Type empty ")
    @Test
    public void TC_0019_TypeEmpty () {
        //https://qa-gm3.quaspareparts.com/
        bot.navigate("https://qa-gm3.quaspareparts.com");
        bot.click(By.className("login-button"));
        //https://a3m-qa-gm3.quaspareparts.com/login
        bot.type(By.id("username"),"testevolve12@testevolve.com");
        bot.type(By.id("password"),"DJK7wyf8_ZpG464");
        bot.click(By.cssSelector("button[type='submit']"));

        //-------------------------------------------------------
        remoteUnitPage = new RemoteUnits(driver,bot);
        remoteUnitPage.goTo().goToAddNewRemoteUnit();

        newRemoteUnitPage = new NewRemoteUnit(driver,bot);


        newRemoteUnitPage.addRemoteName("test").addRemoteType(null).ClickingOnSaveButton();

        String actualText = newRemoteUnitPage.ErrorMSGType();
        Assert.assertEquals(actualText, "Please select a type for department");


    }
}
