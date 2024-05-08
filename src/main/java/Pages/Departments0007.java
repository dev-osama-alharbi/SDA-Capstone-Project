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
public class Departments0007 extends Pages {

    //private final By DepartmentName = By.xpath("//b[text()='room1']");
    private final By AddDepartment = By.xpath("//button[@class='btn btn-info float-end text-white']");
    private final By DepartmentNameField = By.id("name");
    private final By DepartmentNameFieldSelector = By.id("react-select-2-input");
    private final By DepartmentRoleFieldSelector = By.id("react-select-3-input");

    private final By SaveButton = By.xpath("//button[text()='Save']");
    private  final By TextError = By.xpath("//span[@class='text-danger']");

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public Departments0007(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    private void WaitFor(By by){
        boolean displayed = false;
        do{
            try{
                Thread.sleep(3000);
                displayed = driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException noSuchElementException){
                driver.navigate().refresh();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while(!displayed);
    }

    @Step("Clicking on Add New Department name to navigate to new department page")
    public Departments0007 ClickOnAddNewDepartment(){
        WaitFor(AddDepartment);
        bot.click(AddDepartment);
        return this;
    }
    @Step("Department name empty")
    public Departments0007 EmptyDepartmentName(){
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField,  Keys.CONTROL + "a");
        bot.type(DepartmentNameField,  Keys.DELETE);
        //bot.type(DepartmentNameField,  Keys.ENTER);
        return this;
    }
    @Step(" Department name not empty")
    public Departments0007 NotEmptyDepartmentName(){
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField,"NameForTesting"+Keys.ENTER);
        return this;
    }


    @Step("Department type empty")
    public Departments0007 EmptyDepartmentType(){
        bot.click(DepartmentNameFieldSelector);
        bot.type(DepartmentNameFieldSelector,Keys.CONTROL + "a");
        bot.type(DepartmentNameFieldSelector, Keys.DELETE);

        return this;
    }
    @Step("Department type not empty")
    public Departments0007 NotEmptyDepartmentType(){
        bot.click(DepartmentNameFieldSelector);
        bot.type(DepartmentNameFieldSelector,"Department"+Keys.ENTER);
        return this;
    }
    @Step("Department role empty")
    public Departments0007 EmptyDepartmentRole(){
        bot.click(DepartmentRoleFieldSelector);
        bot.type(DepartmentRoleFieldSelector,Keys.CONTROL + "a");
        bot.type(DepartmentRoleFieldSelector, Keys.DELETE);

        return this;
    }
    @Step("Department roles not empty")
    public Departments0007 NotEmptyDepartmentRole(){
        bot.click(DepartmentRoleFieldSelector);
        bot.type(DepartmentRoleFieldSelector,"Business Owner"+Keys.ENTER);
        return this;
    }
    @Step("Clicking On Save Button")
    public Departments0007 ClickingOnSaveButton(){
        bot.click(SaveButton);
        return this;
    }
    @Step("Getting the message")
    public String GetTextError() {
        //bot.getText(TextError);
        return bot.getText(TextError);
    }
}
