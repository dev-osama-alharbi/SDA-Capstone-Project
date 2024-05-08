package sda.capstone;

import Pages.Departments0007;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class addNewDepartment extends TestBase {
    private final By login = By.xpath("//a[@class='login-button']");
    private final By name = By.id("username");
    private final By pass = By.id("password");
    private final By sign = By.xpath("//button[@type='submit']");
    @Step("random test")
    @Test(testName = "Adding new department with the name and type not empty")
    public void addNewDepartmentPositiveScenario() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        Departments0007 departments = new Departments0007(driver,bot);
        departments.ClickOnAddNewDepartment()
                .NotEmptyDepartmentName()
                .NotEmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton();
    }
    @Test(testName = "Adding new department with empty department name")
    public void addNewDepartmentNegativeScenarioForDepartmentNameEmpty() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        Departments0007 departments = new Departments0007(driver,bot);
        departments.ClickOnAddNewDepartment()
                .EmptyDepartmentName()
                .NotEmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton().GetTextError();
        Assert.assertEquals(departments.GetTextError(),"Please enter a name for department");

    }
    @Test(testName = "Adding new department with empty department type")
    public void addNewDepartmentNegativeScenarioForDepartmentTypeEmpty() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        Departments0007 departments = new Departments0007(driver,bot);
        departments.ClickOnAddNewDepartment()
                .NotEmptyDepartmentName()
                .EmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton()
                .GetTextError();

        Assert.assertEquals(departments.GetTextError(),"Please select a type for department");

    }
}