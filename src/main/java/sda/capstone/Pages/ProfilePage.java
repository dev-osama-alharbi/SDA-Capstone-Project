package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.impl.AssertBooleanTestImpl;
import sda.capstone.impl.AssertStringTestImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProfilePage extends PageBase {
    private final By mainContentDiv = By.id("MainContent");
    private final By changePasswordButton = By.id("changePasswordButton");
    private final By editMyProfileButton = By.cssSelector("span button.btn");
    private final By submitEditMyProfileButton = By.xpath("//span//button[1]");
    private final By cancelEditMyProfileButton = By.xpath("//span//button[2]");
    private final By emailLabel = By.id("email");
    private final By usernameInput = By.id("username");
    private final By usernameAlert = By.cssSelector("span.text-danger");
    private final By successfulEditPopup = By.className("toast");
    private final By newPasswordInputText = By.id("newPassword");
    private final By reNewPasswordInputText = By.id("newPassword2");
    private final By changePasswordConformButton = By.xpath("//button[contains(text(),'Confirm')]");
    private final By changePasswordPopup = By.className("modal-content");
    private final By changePasswordInvalidAlert = By.className("alert");
    private final By changePasswordInvalidAlertCloseButton = By.cssSelector(".alert > button");
    private final By userHeaderButton = By.xpath("(//div[@id='Header']//button)[2]");
    private final By logoutButton = By.xpath("//a[text()='Logout']");
    private final By passwordForm = By.className("modal-body");
    public ProfilePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("click change password button")
    public ProfilePage clickChangePassword(){
        bot.click(changePasswordButton);
        bot.capturingScreenshotEvidence(mainContentDiv,changePasswordButton);
        return this;
    }

    @Step("click change my profile button")
    public ProfilePage clickEditMyProfile(){
        bot.click(editMyProfileButton);
        bot.capturingScreenshotEvidence(mainContentDiv,editMyProfileButton);
        return this;
    }

    public ProfilePage editPassword(String newPassword,String reNewPassword){
        bot.type(newPasswordInputText,newPassword);
        bot.type(reNewPasswordInputText,reNewPassword);
        return this;
    }

    public ProfilePage clickChangePasswordConform(){
        bot.click(changePasswordConformButton);
        return this;
    }

    public ProfilePage cancelEditMyProfile(){
        bot.click(cancelEditMyProfileButton);
        return this;
    }

    public ProfilePage submitEditMyProfile(){
        bot.click(submitEditMyProfileButton);
        return this;
    }

    public ProfilePage alertCloseButton(){
        bot.click(changePasswordInvalidAlertCloseButton);
        return this;
    }

    @Step("Assert Alert")
    public ProfilePage assertAlert(AssertStringTestImpl assertTest){
        changePasswordInvalidPopupCapturingScreenshot();
        assertTest.assertString(bot.getText(changePasswordInvalidAlert));
        return this;
    }

    public ProfilePage changePasswordInvalidPopupCapturingScreenshot(){
        bot.capturingScreenshotEvidence(changePasswordPopup,changePasswordInvalidAlert);
        return this;
    }

    @Step("Assert Email Cannot Be Change")
    public ProfilePage assertEmailCannotBeChange(AssertStringTestImpl assertTest) {
        emailLabelCapturingScreenshot();
        assertTest.assertString(bot.getTagName(emailLabel));
        return this;
    }

    public ProfilePage emailLabelCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,emailLabel);
        return this;
    }

    public ProfilePage editUsername(String username) {
        bot.type(usernameInput,username);
        return this;
    }

    public ProfilePage editUsernameEmpty() {
        bot.type(usernameInput, "");
        bot.type(usernameInput, "A"+Keys.BACK_SPACE);
        return this;
    }

    public ProfilePage usernameAlertCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,usernameAlert);
        return this;
    }

    @Step("Assert username alert")
    public ProfilePage assertUsernameAlert(AssertStringTestImpl assertTest) {
        usernameAlertCapturingScreenshot();
        assertTest.assertString(bot.getText(usernameAlert));
        return this;
    }

    @Step("assert Edit Successful Filer Popup")
    public ProfilePage assertEditSuccessfulFilerPopup(AssertStringTestImpl assertTest) {
        editSuccessfulFilerPopupCapturingScreenshot();
        assertTest.assertString(bot.getText(successfulEditPopup));
        return this;
    }

    public ProfilePage editSuccessfulFilerPopupCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,successfulEditPopup);
        return this;
    }

    public ProfilePage editUsernameInputIsDisplayCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,usernameInput);
        return this;
    }

    @Step("Assert username input is display")
    public ProfilePage assertUsernameInputIsDisplay(AssertStringTestImpl assertTest) {
        editUsernameInputIsDisplayCapturingScreenshot();
        assertTest.assertString(bot.getTagName(usernameInput));
        return this;
    }

    public StartPage logout() {
        bot.click(userHeaderButton);
        bot.click(logoutButton);
        return new StartPage(driver,bot,wait);
    }


    public ProfilePage assertLoggedIn(AssertBooleanTestImpl assertStringTest) {
        emailInputIsDisplayCapturingScreenshot();
        assertStringTest.assertBoolean(bot.isDisplayed(emailLabel));
        return this;
    }


    public ProfilePage emailInputIsDisplayCapturingScreenshot(){
        bot.capturingScreenshotEvidence(mainContentDiv,emailLabel);
        return this;
    }

    public ProfilePage waitUntilPasswordFormIsClosed() {
        bot.waitUntilIsNotDisplayed(passwordForm);
        return this;
    }
}
