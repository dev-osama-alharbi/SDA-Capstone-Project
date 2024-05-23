package sda.capstone.UI.us0004;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


//mvn clean test -Dtest=US04TC37EmailCannotBeChangedTest
public class TC0037 extends UITestBase {
    private final String usernameMain = "t4@testiva.com";
    private final String passwordMain = "Z6TkqEfKvDaUd-Y";
    @Test(testName = "TC_0037: Email cannot be changed")
    @Step("US_0004: Edit profile information in profile module.")
    public void emailCannotBeChangedTest(){
        emailCannotBeChanged();
    }
    @Step("TC_0037: Email cannot be changed")
    private void emailCannotBeChanged(){
        HomePage homePage = login();
        ProfilePage profilePage = changeMyProfile(homePage);
        startTestEmailCannotBeChanged(profilePage);
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(username, password);
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
