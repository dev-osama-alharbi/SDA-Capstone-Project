package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.impl.AssertBooleanTestImpl;
import sda.capstone.impl.AssertStringTestImpl;

public class MyMembershipsPage extends PageBase {
    private final By mainContentDiv = By.id("MainContent");
    private final By membershipsBox = By.cssSelector(".col-4");
    private final By membershipsBoxA = By.cssSelector(".col-4 a");
    private final By membershipsMainP = By.cssSelector(".col-4 a p.mb-0");
    public MyMembershipsPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("Assert My Memberships")
    public MyMembershipsPage assertMyMembershipsIsDisplayed(AssertBooleanTestImpl assertTest){
        bot.isDisplayed(By.tagName("h5"));
        myMembershipsCapturingScreenshot();
        assertTest.assertBoolean(bot.isDisplayed(membershipsBoxA));
        return this;
    }

    public MyMembershipsPage myMembershipsCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,membershipsBox);
        return this;
    }

    public MyMembershipsInformationPage clickMyMembershipsInformation(){
        bot.click(membershipsBoxA);
        return new MyMembershipsInformationPage(driver,bot,wait);
    }
}
