package sda.capstone.us0006;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.capstone.Pages.CompanyPage;
import sda.capstone.Pages.HomePage;
import sda.capstone.Pages.StartPage;
import sda.capstone.TestBase;


//mvn clean test -Dtest=TC0010
public class TC0010 extends TestBase {
    private final String mailMain = "t4@testiva.com";
    private final String passwordMain = "Z6TkqEfKvDaUd-Y";

    @Test(testName = "TC_0010: Ensure required fields", dataProvider = "testTypes")
    @Step("US_0005: Displays the memberships in the Memberships module.")
    public void TC0008(String testTypes){
        ensureRequiredFields(testTypes);
    }

    @Step("TC_0010: Ensure required fields")
    private void ensureRequiredFields(String testTypes){
        HomePage homePage = login();
        CompanyPage companyPage = goToCompanyPage(homePage);
        switch (testTypes){
            case "name" -> checkNameFieldIsMandatory(companyPage);
            case "email" -> checkEmailFieldIsMandatory(companyPage);
        }
    }

    @Step("Login")
    private HomePage login(){
        return new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(mailMain, passwordMain);
    }

    @Step("Go To Company Page")
    private CompanyPage goToCompanyPage(HomePage homePage){
        return homePage.goToCompanyPage();
    }

    @Step("make sure name field is mandatory")
    private CompanyPage checkNameFieldIsMandatory(CompanyPage companyPage){
        return companyPage
                .clickEditCompany()
                .typeNameEmpty()
                .clickSaveCompany()
                .assertEmptyNameAlert(actual -> {
                    Assert.assertEquals(actual, "Please enter a name for company");
                });
    }

    @Step("make sure email field is mandatory")
    private CompanyPage checkEmailFieldIsMandatory(CompanyPage companyPage){
        return companyPage
                .clickEditCompany()
                .typeEmailEmpty()
                .clickSaveCompany()
                .assertEmptyEmailAlert(Assert::assertFalse);
    }

    @DataProvider(name = "testTypes")
    public Object[][] orders() {
        return new Object[][] {
                { "name" },
                { "email" }
        };
    }
}
