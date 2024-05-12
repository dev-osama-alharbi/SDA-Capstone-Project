package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.impl.AssertBooleanTestImpl;
import sda.capstone.impl.AssertStringTestImpl;

public class CompanyPage extends PageBase {
    private final By mainContentDiv = By.id("MainContent");
    private final By editButton = By.xpath("//button[contains(.,'Edit')]");
    private final By saveButton = By.xpath("//button[contains(.,'Save')]");
    private final By nameInput = By.id("name");
    private final By nameAlert = By.cssSelector("span.text-danger");
    private final By emailAlert = By.cssSelector("span.text-danger");
    private final By emailLabel = By.xpath("//label[@name='email']");
    private final By emailBox = By.xpath("//div[@class='col-md-9']//div[1]//div[3]");
    private final By emailInput = By.xpath("//input[@name='email']");
//    private final By nameAlert = By.cssSelector("span.text-danger");
    public CompanyPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public CompanyPage clickEditCompany(){
        bot.click(editButton);
        return this;
    }

    public CompanyPage clickSaveCompany(){
        bot.click(saveButton);
        return this;
    }

    public CompanyPage typeNameEmpty(){
        bot.type(nameInput,"");
        bot.type(nameInput,"a"+ Keys.BACK_SPACE);
        return this;
    }

    public CompanyPage typeEmailEmpty(){
        bot.type(emailInput,"");
        bot.type(emailInput,"a"+ Keys.BACK_SPACE);
        return this;
    }

    @Step("Assert empty name alert")
    public CompanyPage assertEmptyNameAlert(AssertStringTestImpl assertTest) {
        emptyNameAlertCapturingScreenshot();
        assertTest.assertString(bot.getText(nameAlert));
        return this;
    }

    public CompanyPage emptyNameAlertCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,nameAlert);
        return this;
    }

    @Step("Assert empty email alert")
    public CompanyPage assertEmptyEmailAlert(AssertBooleanTestImpl assertTest) {
        emptyEmailAlertCapturingScreenshot();
        assertTest.assertBoolean(bot.isDisplayed(emailLabel));
        return this;
    }

    public CompanyPage emptyEmailAlertCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,emailBox);
        return this;
    }
}
