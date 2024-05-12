package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.impl.AssertBooleanTestImpl;
import sda.capstone.impl.AssertStringTestImpl;

public class MyMembershipsInformationPage extends PageBase {
    private final By mainContentDiv = By.id("MainContent");
    private final By membershipInformationH5 = By.tagName("H5");
    public MyMembershipsInformationPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("Assert My Memberships")
    public MyMembershipsInformationPage assertMyMembershipsInformationIsDisplayed(AssertBooleanTestImpl assertTest){
        myMembershipsInformationCapturingScreenshot();
        assertTest.assertBoolean(bot.isDisplayed(membershipInformationH5));
        return this;
    }

    public MyMembershipsInformationPage myMembershipsInformationCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,membershipInformationH5);
        return this;
    }
}
