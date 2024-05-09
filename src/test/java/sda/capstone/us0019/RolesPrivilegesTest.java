package sda.capstone.us0019;

import Pages.AddAndListDepartment;
import Pages.RolesPrivileges;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;

public class RolesPrivilegesTest extends TestBase {
    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";
    @Step("random test")
    @Test(testName = "Listing Privileges of Roles")
    public void listThePrivilegesOfroles() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);

        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/roles");
        RolesPrivileges privileges = new RolesPrivileges(driver,bot,wait);
        privileges.ClickOnBusinessOwner().ListRoles();
        System.out.println("Privileges:   " + privileges.ListRoles());

    }
}