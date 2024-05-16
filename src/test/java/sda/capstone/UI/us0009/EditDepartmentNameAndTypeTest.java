package sda.capstone.UI.us0009;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.listener.CustomListener;
import sda.capstone.Pages.*;

@Listeners(CustomListener.class)
public class EditDepartmentNameAndTypeTest extends UITestBase {

    @Step("Testing the functionality of editing Department name and type")
    @Test(priority = 1)
    public void editDepartmentNameAndTypeTest() {

        StartPage startPage = new StartPage(driver,bot,wait);

        startPage.
                goTo().
                clickLoginButton().
                login(username,password);

        DepartmentsPage departmentsPage = new DepartmentsPage(driver,bot,wait);

        String text =
                departmentsPage.
                goTo().
                ClickOnDepartmentName().
                ClickOnEdit().
                EditTheDepartmentName().
                EditTheDepartmentType().
                ClickingOnSaveButton().
                GetTheSuccessMessage();

        Assert.assertEquals(text,"Changes successfully saved");
    }

    @Step("Testing the functionality of leaving Department name empty")
    @Test(priority = 2)
    public void editWithEmptyDepartmentNameTest() {

        StartPage startPage = new StartPage(driver,bot,wait);

        startPage.
                goTo().
                clickLoginButton().
                login(username,password);

        DepartmentsPage departmentsPage = new DepartmentsPage(driver,bot,wait);

        String text =
                departmentsPage.
                goTo().
                ClickOnDepartmentName().
                ClickOnEdit().
                LeaveTheDepartmentNameEmpty().
                ClickingOnSaveButton().
                GetTheFailureMessage();

        Assert.assertEquals(text,"Please enter a name for department");
    }

    @Step("Testing the functionality of leaving Department type empty")
    @Test(priority = 3)
    public void editWithEmptyDepartmentTypeTest() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.
                goTo().
                clickLoginButton().
                login(username,password);

        DepartmentsPage departmentsPage = new DepartmentsPage(driver,bot,wait);

        String text =
                departmentsPage.
                goTo().
                ClickOnDepartmentName().
                ClickOnEdit().
                LeaveTheDepartmentTypeEmpty().
                ClickingOnSaveButton().
                GetTheFailureMessage();

        Assert.assertEquals(text,"Please select a type for department");
    }

    @Step("Testing the functionality of deleting the department")
    @Test(priority = 4)
    public void deleteTheDepartmentTest() {

        StartPage startPage = new StartPage(driver,bot,wait);
        startPage.
                goTo().
                clickLoginButton().
                login(username,password);

        DepartmentsPage departmentsPage = new DepartmentsPage(driver,bot,wait);

        String text = departmentsPage.
                goTo().
                ClickOnDepartmentName().
                ClickOnEdit().
                DeleteTheDepartment();

        Assert.assertEquals(text,"Departments");
    }

}
