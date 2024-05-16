package sda.capstone.UI.us0004;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


//mvn clean test -Dtest=US04TC38EditProfileWithValidUsernameTest
public class TC0038 extends UITestBase {

//    private final String usernameMain = "t4@testiva.com";
//    private final String passwordMain = "Z6TkqEfKvDaUd-Y";
    private final String usernameValid = "t4testiva.com2";

    @Test(testName = "TC_0038: Edit profile with valid username")
    @Step("US_0004: Edit profile information in profile module.")
    public void TC0038(){
        validUsernameTest();
    }

    @Step("TC_0039: Edit profile with valid username")
    private void validUsernameTest(){
        HomePage homePage = login();
        ProfilePage profilePage = clickEditMyProfile(homePage);
        usernameValid(profilePage);
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(username, password);
    }

    @Step("Go To ProfilePage and edit my profile")
    private ProfilePage clickEditMyProfile(HomePage homePage){
        return homePage.goToProfilePage()
                .clickEditMyProfile();
    }

    @Step("Enter valid username")
    private void usernameValid(ProfilePage profilePage){
        profilePage
                .editUsername(usernameValid)
                .clickEditMyProfile()
                .assertEditSuccessfulFilerPopup(actual -> {
                    Assert.assertEquals(actual,"User information updated successfully");
                });
    }
}
