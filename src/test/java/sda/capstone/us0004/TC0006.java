package sda.capstone.us0004;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.ProfilePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;

//US04TC06EditProfileWithValidPasswordTest
public class TC0006 extends TestBase {
    private String passwordChanged = "Z6TkqEfKvDaUd_Y2";

    @Test(testName = "TC_0006: Passwords: uppercase (A-Z), lowercase (a-z), numbers (0-9), and .@#$%_&.")
    @Step("US_0004: Edit profile information in profile module.")
    public void TC0007(){
        passwordNotConstraintsTest();
    }
    @Step("TC_0007: Passwords: uppercase (A-Z), lowercase (a-z), numbers (0-9), and .@#$%_&.")
    private void passwordNotConstraintsTest(){
        HomePage homePage = login();
        ProfilePage profilePage = changePasswordPopup(homePage);
        passwordChangedTest(profilePage);
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

    @Step("password changed")
    private void passwordChangedTest(ProfilePage profilePage){
        profilePage
                .editPassword(passwordChanged,passwordChanged)
                .clickChangePasswordConform()
                .assertEditSuccessfulFilerPopup(actual -> {
                    Assert.assertEquals(actual,"Change password successfully");
                })
                .logout()
                .clickLoginButton()
                .login(username,passwordChanged)
                .goToProfilePage()
                .assertLoggedIn(Assert::assertTrue)
                .clickChangePassword()
                .editPassword(password,password)
                .clickChangePasswordConform()
                .waitUntilPasswordFormIsClosed();
    }
}
