package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.capstone.ActionsBot;
import sda.capstone.Pages;

import java.time.Duration;

//Displays the departments registered in the Departments module and lists their authorized roles
public class AddAndListDepartment extends Pages {

    //private final By DepartmentName = By.xpath("//b[text()='room1']");
    private final By AddDepartment = By.xpath("//button[@class='btn btn-info float-end text-white']");
    private final By DepartmentNameField = By.id("name");
    private final By DepartmentNameFieldSelector = By.id("react-select-2-input");
    private final By DepartmentRoleFieldSelector = By.id("react-select-3-input");
    private final By SaveButton = By.xpath("//button[text()='Save']");
    private final By TextError = By.xpath("//span[@class='text-danger']");
    private final By RegisteredDepartment = By.xpath("//a[@href='#/department/1677064640369316/727']");
    private final By RegisteredDepartmentName = By.xpath("//span[@class='fw-bold fs-4']");
    private final By RegisteredDepartmentRole = By.xpath("//span[@class='roles-box p-2 me-2']");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public AddAndListDepartment(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    private void WaitFor(By by) {
        boolean displayed = false;
        do {
            try {
                Thread.sleep(3000);
                displayed = driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException noSuchElementException) {
                driver.navigate().refresh();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!displayed);
    }

    @Step("Clicking on Add New Department name to navigate to new department page")
    public AddAndListDepartment ClickOnAddNewDepartment() {
        WaitFor(AddDepartment);
        bot.click(AddDepartment);
        return this;
    }

    @Step("Department name empty")
    public AddAndListDepartment EmptyDepartmentName() {
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField, Keys.CONTROL + "a");
        bot.type(DepartmentNameField, Keys.DELETE);
        //bot.type(DepartmentNameField,  Keys.ENTER);
        return this;
    }

    @Step(" Department name not empty")
    public AddAndListDepartment NotEmptyDepartmentName() {
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField, "NameForTesting" + Keys.ENTER);
        return this;
    }


    @Step("Department type empty")
    public AddAndListDepartment EmptyDepartmentType() {
        bot.click(DepartmentNameFieldSelector);
        bot.type(DepartmentNameFieldSelector, Keys.CONTROL + "a");
        bot.type(DepartmentNameFieldSelector, Keys.DELETE);

        return this;
    }

    @Step("Department type not empty")
    public AddAndListDepartment NotEmptyDepartmentType() {
        bot.click(DepartmentNameFieldSelector);
        bot.type(DepartmentNameFieldSelector, "Department" + Keys.ENTER);
        return this;
    }

    @Step("Department role empty")
    public AddAndListDepartment EmptyDepartmentRole() {
        bot.click(DepartmentRoleFieldSelector);
        bot.type(DepartmentRoleFieldSelector, Keys.CONTROL + "a");
        bot.type(DepartmentRoleFieldSelector, Keys.DELETE);

        return this;
    }

    @Step("Department roles not empty")
    public AddAndListDepartment NotEmptyDepartmentRole() {
        bot.click(DepartmentRoleFieldSelector);
        bot.type(DepartmentRoleFieldSelector, "Business Owner" + Keys.ENTER);
        return this;
    }

    @Step("Clicking On Save Button")
    public AddAndListDepartment ClickingOnSaveButton() {
        bot.click(SaveButton);
        return this;
    }
    @Step("Clicking On Registered Department")
    public AddAndListDepartment ClickingOnRegisteredDepartment(){
        bot.click(RegisteredDepartment);
        return this;
    }


    @Step("Getting the Registered Department Name")
    public String GettingOnRegisteredDepartmentName(){
        wait.until(f -> {
            driver.findElement(RegisteredDepartmentName).isDisplayed();
            return true;
        });
        return bot.getText(RegisteredDepartmentName);
}


    @Step("Getting the Registered Department role")
    public String GettingOnRegisteredDepartmentRole(){
        wait.until(f -> {
            driver.findElement(RegisteredDepartmentRole).isDisplayed();
            return true;
        });
        return bot.getText(RegisteredDepartmentRole);
}

    @Step("Getting the message")
    public String GetTextError() {
        //bot.getText(TextError);
        return bot.getText(TextError);
    }
}

