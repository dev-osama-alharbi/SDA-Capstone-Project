import Pages.Departments;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.TestBase;

public class EditDepartmentNameAndTypeTest extends TestBase {
    private final By login = By.xpath("//a[@class='login-button']");
    private final By name = By.id("username");
    private final By pass = By.id("password");
    private final By sign = By.xpath("//button[@type='submit']");

    @Step("random test")
    @Test
    public void editDepartmentNameAndTypeTest() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        Departments departments = new Departments(driver,bot);
        String text = departments.ClickOnDepartmentName().ClickOnEdit().EditTheDepartmentName().EditTheDepartmentType().ClickingOnSaveButton().GetTheSuccessMessage();
        Assert.assertEquals(text,"Changes successfully saved");
    }

    @Step("random test")
    @Test
    public void editDepartmentNameWithEmptyTest() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        Departments departments = new Departments(driver,bot);

        String text = departments.ClickOnDepartmentName().ClickOnEdit().LeaveTheDepartmentNameEmpty().ClickingOnSaveButton().GetTheRedMessage();
        Assert.assertEquals(text,"Please enter a name for department");
    }

    @Step("random test")
    @Test
    public void editDepartmentTypeWithEmptyTest() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");
        //bot.click(login);

        bot.type(name,"testevolve12@testevolve.com");
        bot.type(pass,"DJK7wyf8_ZpG464");
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/department");

        Departments departments = new Departments(driver,bot);

        String text = departments.ClickOnDepartmentName().ClickOnEdit().LeaveTheDepartmentTypeEmpty().ClickingOnSaveButton().GetTheRedMessage();
        Assert.assertEquals(text,"Please select a type for department");
    }

}
