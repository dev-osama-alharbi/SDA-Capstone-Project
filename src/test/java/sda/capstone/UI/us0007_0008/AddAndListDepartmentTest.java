package sda.capstone.UI.us0007_0008;

import Pages.AddAndListDepartment;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.Pages.*;

public class AddAndListDepartmentTest extends UITestBase {
    @Step("random test")
    @Test(priority = 1 ,testName = "Adding new department with empty department name")
    public void addNewDepartmentNegativeScenarioForDepartmentNameEmpty() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot,wait);
        departments.ClickOnAddNewDepartment()
                .EmptyDepartmentName()
                .NotEmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton().GetTextError();
        Assert.assertEquals(departments.GetTextError(),"Please enter a name for department");

    }
    @Test(priority = 2 ,testName = "Adding new department with empty department type")
    public void addNewDepartmentNegativeScenarioForDepartmentTypeEmpty() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot,wait);
        departments.ClickOnAddNewDepartment()
                .NotEmptyDepartmentName()
                .EmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton()
                .GetTextError();

        Assert.assertEquals(departments.GetTextError(),"Please select a type for department");

    }
    @Test(priority = 3 ,testName = "Adding new department with the name and type not empty")
    public void addNewDepartmentPositiveScenario() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot,wait);
        departments.ClickOnAddNewDepartment()
                .NotEmptyDepartmentName()
                .NotEmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton();
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/#/departments/department");
    }
    @Test(priority = 4 ,testName = "Getting department name and role")
    public void ListDepartmentPositiveScenario() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.goTo().clickLoginButton().login(username,password);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot,wait);
        departments.ClickingOnRegisteredDepartment().GettingOnRegisteredDepartmentName();

        Assert.assertEquals(departments.GettingOnRegisteredDepartmentName(),"NameForTesting");

        departments.GettingOnRegisteredDepartmentRole();

        Assert.assertEquals(departments.GettingOnRegisteredDepartmentRole()," Business Owner ");

        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

    }
}