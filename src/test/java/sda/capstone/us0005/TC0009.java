package sda.capstone.us0005;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;


//mvn clean test -Dtest=TC0008
public class TC0009 extends TestBase {
    private final String mailMain = "t4@testiva.com";
    private final String passwordMain = "Z6TkqEfKvDaUd-Y";

    @Test(testName = "TC_0009: Access membership information")
    @Step("US_0005: Displays the memberships in the Memberships module.")
    public void TC0009(){
        validMyMembershipsTest();
    }

    @Step("TC_0009: Access membership information")
    private void validMyMembershipsTest(){
        HomePage homePage = login();
        assertMyMembershipsInformation(homePage);
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(mailMain, passwordMain);
    }

    @Step("Go To My Memberships and My Memberships information")
    private void assertMyMembershipsInformation(HomePage homePage){
        homePage
                .goToMyMembershipsPage()
                .clickMyMembershipsInformation()
                .assertMyMembershipsInformationIsDisplayed(Assert::assertTrue);
    }
}
