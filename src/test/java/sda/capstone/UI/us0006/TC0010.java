package sda.capstone.UI.us0006;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;


//mvn clean test -Dtest=TC0010
public class TC0010 extends UITestBase {
    private final String mailMain = "t4@testiva.com";
    private final String passwordMain = "Z6TkqEfKvDaUd-Y";

    @Test(testName = "TC_0010: Ensure required fields", dataProvider = "testTypes")
    @Step("US_0006: Edit the registered company in the Company module.")
    public void ensureRequiredFieldsTest(String testTypes){
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
                .login(username, password);
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
