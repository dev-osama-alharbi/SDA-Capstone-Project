package sda.capstone.us0005;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;


//mvn clean test -Dtest=TC0008
public class TC0008 extends TestBase {

    @Test(testName = "TC_0008: Display memberships")
    @Step("US_0005: Displays the memberships in the Memberships module.")
    public void TC0008(){
        validMyMembershipsTest();
    }

    @Step("TC_0008: Display memberships")
    private void validMyMembershipsTest(){
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
