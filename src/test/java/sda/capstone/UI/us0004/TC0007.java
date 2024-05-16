package sda.capstone.UI.us0004;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


//mvn clean test -Dtest=US04TC07EditProfileWithInvalidPasswordTest
public class TC0007 extends UITestBase {
    private final String passwordInvalidWithoutUppercase = "uppercase";
    private final String passwordInvalidWithoutLowercase = "LOWERCASE";
    private final String passwordInvalidWithoutNumbers = "NumbersOne";
    private final String passwordInvalidWithoutSpecialCharacter = "SpecialCharacter2";
    private final String passwordInvalidLessThan_8 = "less8";
    private final String passwordInvalidBiggerThan_20 = "passwordInvalidBiggerThan_20";
    @Test(testName = "TC_0007: Passwords: uppercase (A-Z), lowercase (a-z), numbers (0-9), and .@#$%_&.")
    @Step("US_0004: Edit profile information in profile module.")
    public void TC0007(){
        passwordNotConstraintsTest();
    }
    @Step("TC_0007: Passwords: uppercase (A-Z), lowercase (a-z), numbers (0-9), and .@#$%_&.")
    private void passwordNotConstraintsTest(){
        HomePage homePage = login();
        ProfilePage profilePage = changePasswordPopup(homePage);
        startTestInvalidPassword(profilePage);
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(username, password);
    }

    @Step("Go To ProfilePage and open Change Password Popup")
    private ProfilePage changePasswordPopup(HomePage homePage){
        return homePage.goToProfilePage()
                .clickChangePassword();
    }

    @Step("Start test invalid password")
    private void startTestInvalidPassword(ProfilePage profilePage){
        passwordNotContainUppercaseLetterTest(profilePage);
        passwordNotContainLowercaseLetterTest(profilePage);
        passwordNotContainDigitTest(profilePage);
        passwordNotSpecialCharactersTest(profilePage);
        passwordLimitCharactersTest(profilePage);
    }

    @Step("Password must be between 8 to 20 characters long")
    private void passwordLimitCharactersTest(ProfilePage profilePage){
        passwordLimitLessThan8Test(profilePage);
        passwordLimitBiggerThan20Test(profilePage);
    }

    @Step("less than 8")
    private void passwordLimitLessThan8Test(ProfilePage profilePage){
        profilePage
                .editPassword(passwordInvalidLessThan_8,passwordInvalidLessThan_8)
                .clickChangePasswordConform()
                .assertAlert(actual -> {
                    Assert.assertEquals(actual,"Password must be between 8 to 20 characters long.");
                })
//                .changePasswordInvalidPopupCapturingScreenshot()
                .alertCloseButton();
    }

    @Step("bigger than 20")
    private void passwordLimitBiggerThan20Test(ProfilePage profilePage){
        profilePage
                .editPassword(passwordInvalidBiggerThan_20,passwordInvalidBiggerThan_20)
                .clickChangePasswordConform()
                .assertAlert(actual -> {
                    Assert.assertEquals(actual,"Password must be between 8 to 20 characters long.");
                })
//                .changePasswordInvalidPopupCapturingScreenshot()
                .alertCloseButton();
    }

    @Step("Password must contain at least one uppercase")
    private void passwordNotContainUppercaseLetterTest(ProfilePage profilePage){
        profilePage
                .editPassword(passwordInvalidWithoutUppercase,passwordInvalidWithoutUppercase)
                .clickChangePasswordConform()
                .assertAlert(actual -> {
                    Assert.assertEquals(actual,"Password must contain at least one uppercase.");
                })
//                .changePasswordInvalidPopupCapturingScreenshot()
                .alertCloseButton();
    }

    @Step("Password must contain at least one lowercase")
    private void passwordNotContainLowercaseLetterTest(ProfilePage profilePage){
        profilePage
                .editPassword(passwordInvalidWithoutLowercase,passwordInvalidWithoutLowercase)
                .clickChangePasswordConform()
                .assertAlert(actual -> {
                    Assert.assertEquals(actual,"Password must contain at least one lowercase.");
                })
//                .changePasswordInvalidPopupCapturingScreenshot()
                .alertCloseButton();
    }

    @Step("Password must contain at least one digit")
    private void passwordNotContainDigitTest(ProfilePage profilePage){
        profilePage
                .editPassword(passwordInvalidWithoutNumbers,passwordInvalidWithoutNumbers)
                .clickChangePasswordConform()
                .assertAlert(actual -> {
                    Assert.assertEquals(actual,"Password must contain at least one digit.");
                })
//                .changePasswordInvalidPopupCapturingScreenshot()
                .alertCloseButton();
    }

    @Step("Password must contain special characters from .@#$%_&")
    private void passwordNotSpecialCharactersTest(ProfilePage profilePage){
        profilePage
                .editPassword(passwordInvalidWithoutSpecialCharacter,passwordInvalidWithoutSpecialCharacter)
                .clickChangePasswordConform()
                .assertAlert(actual -> {
                    Assert.assertEquals(actual,"Password must contain special characters from .@#$%_&");
                })
//                .changePasswordInvalidPopupCapturingScreenshot()
                .alertCloseButton();
    }
}
