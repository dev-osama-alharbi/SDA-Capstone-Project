package sda.capstone.UI.us0019;

import Pages.RolesPrivileges;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import sda.capstone.TestBase;
import sda.capstone.Pages.*;

public class RolesPrivilegesTest extends TestBase {
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