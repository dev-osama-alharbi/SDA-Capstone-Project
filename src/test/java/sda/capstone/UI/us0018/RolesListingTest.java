package sda.capstone.UI.us0018;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class RolesListingTest extends UITestBase {

    @Step("Listing test")
    @Test(testName = "Listing the Roles")
    public void listTheRoles() {
        StartPage startPage = new StartPage(driver, bot, wait);
        startPage.goTo().clickLoginButton().login(username, password);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/roles");

        RolesListing roles = new RolesListing(driver, bot, wait);
        String listedRoles = roles.listRoles();
        System.out.println("Listed Roles: " + listedRoles);
    }
}