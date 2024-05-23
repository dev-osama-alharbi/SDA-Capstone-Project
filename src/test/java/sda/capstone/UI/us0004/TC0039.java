package sda.capstone.UI.us0004;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


//mvn clean test -Dtest=US04TC39EditProfileWithInvalidUsernameTest
public class TC0039 extends UITestBase {
    private final String usernameInvalidNotStartWithLetters = "5t4testivacome";
    private final String usernameInvalidEndWithSpecialCharacters = "t4testiva.com_";
    private final String usernameInvalidNotContainLettersNumbersSpecialCharacters = "t4@testevolve.com";

    @Test(testName = "TC_0039: Edit profile with invalid username",dataProvider = "orders")
    @Step("US_0004: Edit profile information in profile module.")
    public void usernameNotStartWithLettersTest(String orders){
        usernameNotStartWithLetters(orders);
    }

    @Step("TC_0039: Edit profile with invalid username")
    private void usernameNotStartWithLetters(String orders){
        HomePage homePage = login();
        ProfilePage profilePage = clickEditMyProfile(homePage);
        switch (orders){
            case "1" -> usernameMustStartWithLetters(profilePage);
            case "2" -> usernameInvalidEndWithSpecialCharacters(profilePage);
            case "3" -> usernameInvalidNotContainLettersNumbersSpecialCharacters(profilePage);
            case "4" -> usernameInvalidEmpty(profilePage);
        }
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

    @Step("Username must start with letters (A-Za-z)")
    private void usernameMustStartWithLetters(ProfilePage profilePage){
        profilePage
                .editUsername(usernameInvalidNotStartWithLetters)
                .assertUsernameAlert(actual -> {
                    Assert.assertEquals(actual,"Username must start with letters (A-Za-z)");
                })
                .clickEditMyProfile()
                .assertEditSuccessfulFilerPopup(actual -> {
                    Assert.assertNotEquals(actual,"User information updated successfully");
                });
    }

    @Step("Username must not end with special characters of -._")
    private void usernameInvalidEndWithSpecialCharacters(ProfilePage profilePage){
        profilePage
                .editUsername(usernameInvalidEndWithSpecialCharacters)
                .assertUsernameAlert(actual -> {
                    Assert.assertEquals(actual,"Username must not end with special characters of -._");
                })
                .clickEditMyProfile()
                .assertEditSuccessfulFilerPopup(actual -> {
                    Assert.assertNotEquals(actual,"User information updated successfully");
                });
    }

    @Step("Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._")
    private void usernameInvalidNotContainLettersNumbersSpecialCharacters(ProfilePage profilePage){
        profilePage
                .editUsername(usernameInvalidNotContainLettersNumbersSpecialCharacters)
                .assertUsernameAlert(actual -> {
                    Assert.assertEquals(actual,"Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._");
                })
                .clickEditMyProfile()
                .assertEditSuccessfulFilerPopup(actual -> {
                    Assert.assertNotEquals(actual,"User information updated successfully");
                });
    }

    @Step("Username cannot be empty")
    private void usernameInvalidEmpty(ProfilePage profilePage){
        profilePage
                .editUsernameEmpty()
                .assertUsernameAlert(actual -> {
                    Assert.assertEquals(actual,"Username cannot be empty");
                })
                .clickEditMyProfile()
                .assertUsernameInputIsDisplay(actual -> {
                    Assert.assertEquals(actual,"input");
                });
    }

    @DataProvider(name = "orders")
    public Object[][] orders() {
        return new Object[][] {
                { "1" },
                { "2" },
                { "3" },
                { "4" }
        };
    }
}
