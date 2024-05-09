package sda.capstone.us0020;

import Pages.AddAndListDepartment;
import Pages.PermissionsListing;
import Pages.RolesPrivileges;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;

public class PermissionsListingTest extends TestBase {
    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";
    @Step("random test")
    @Test(testName = "Listing the Permissions")
    public void listThePermissions() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/permissions");
        PermissionsListing permissions = new PermissionsListing(driver,bot,wait);
        permissions.ListPermissions();
        System.out.println("Permissions:   " + permissions.ListPermissions());

    }
}