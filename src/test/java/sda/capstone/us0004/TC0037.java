package sda.capstone.us0004;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.ProfilePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;


//mvn clean test -Dtest=US04TC37EmailCannotBeChangedTest
public class TC0037 extends TestBase {
    private final String usernameMain = "t4@testiva.com";
    private final String passwordMain = "Z6TkqEfKvDaUd-Y";
    @Test(testName = "TC_0037: Email cannot be changed")
    @Step("US_0004: Edit profile information in profile module.")
    public void TC0037(){
        emailCannotBeChangedTest();
    }
    @Step("TC_0037: Email cannot be changed")
    private void emailCannotBeChangedTest(){
        HomePage homePage = login();
        ProfilePage profilePage = changeMyProfile(homePage);
        startTestEmailCannotBeChanged(profilePage);
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(usernameMain, passwordMain);
    }

    @Step("Go To ProfilePage and edit my profile")
    private ProfilePage changeMyProfile(HomePage homePage){
        return homePage.goToProfilePage()
                .clickEditMyProfile();
    }

    @Step("Start test email cannot be changed")
    private void startTestEmailCannotBeChanged(ProfilePage profilePage){
        profilePage
                .assertEmailCannotBeChange(actual -> {
                    Assert.assertEquals(actual,"label");
                })
                .cancelEditMyProfile();
    }
}
