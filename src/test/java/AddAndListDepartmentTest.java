import Pages.AddAndListDepartment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.TestBase;

public class AddAndListDepartmentTest extends TestBase {
    private final By login = By.xpath("//a[@class='login-button']");
    private final By name = By.id("username");
    private final By pass = By.id("password");
    private final By sign = By.xpath("//button[@type='submit']");
    @Step("random test")
    @Test(priority = 1 ,testName = "Adding new department with empty department name")
    public void addNewDepartmentNegativeScenarioForDepartmentNameEmpty() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot);
        departments.ClickOnAddNewDepartment()
                .EmptyDepartmentName()
                .NotEmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton().GetTextError();
        Assert.assertEquals(departments.GetTextError(),"Please enter a name for department");

    }
    @Test(priority = 2 ,testName = "Adding new department with empty department type")
    public void addNewDepartmentNegativeScenarioForDepartmentTypeEmpty() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot);
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
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        AddAndListDepartment departments = new AddAndListDepartment(driver,bot);
        departments.ClickOnAddNewDepartment()
                .NotEmptyDepartmentName()
                .NotEmptyDepartmentType()
                .NotEmptyDepartmentRole()
                .ClickingOnSaveButton();
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/#/departments/department");
    }
    @Test(priority = 4 ,testName = "Getting department name and role")
    public void ListDepartmentPositiveScenario() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        AddAndListDepartment departments = new AddAndListDepartment(driver,bot);
        departments.ClickingOnRegisteredDepartment().GettingOnRegisteredDepartmentName();
        Assert.assertEquals(departments.GettingOnRegisteredDepartmentName(),"NameForTesting");
        departments.GettingOnRegisteredDepartmentRole();
        Assert.assertEquals(departments.GettingOnRegisteredDepartmentRole()," Business Owner ");
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

    }
}