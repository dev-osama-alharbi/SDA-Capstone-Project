package sda.capstone.UI.us0005;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


//mvn clean test -Dtest=TC0008
public class TC0008 extends UITestBase {

    @Test(testName = "TC_0008: Display memberships")
    @Step("US_0005: Displays the memberships in the Memberships module.")
    public void validMyMembershipsTest(){
        validMyMemberships();
    }

    @Step("TC_0008: Display memberships")
    private void validMyMemberships(){
        HomePage homePage = login();
        assertMyMemberships(homePage);
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(username, password);
    }

    @Step("Go To My Memberships and assert My Memberships")
    private void assertMyMemberships(HomePage homePage){
        homePage
                .goToMyMembershipsPage()
                .assertMyMembershipsIsDisplayed(Assert::assertTrue);
    }
}
