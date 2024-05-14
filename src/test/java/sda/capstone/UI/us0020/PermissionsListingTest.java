package sda.capstone.UI.us0020;

import Pages.PermissionsListing;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import sda.capstone.TestBase;
import sda.capstone.Pages.*;

public class PermissionsListingTest extends TestBase {
    @Step("random test")
    @Test(testName = "Listing the Permissions")
    public void listThePermissions() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/permissions");
        PermissionsListing permissions = new PermissionsListing(driver,bot,wait);
        permissions.ListPermissions();
//        System.out.println("Permissions:   " + permissions.ListPermissions());

    }
}