package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.Pages;

public class Departments  extends Pages {

    protected Wait<WebDriver> wait;
    //private final By DepartmentName = By.xpath("//b[text()='room1']");
    private final By DepartmentName = By.xpath("//b[text()='NameForTesting']");
    private final By EditDepartmentButton = By.xpath("//button[contains(text(),'Edit')]");
    private final By DepartmentNameField = By.id("name");
    private final By DepartmentNameFieldSelector = By.id("react-select-3-input");
    private final By SaveButton = By.xpath("//button[text()='Save']");
    private final By Message = By.xpath("//p[text()='Changes successfully saved']");

    private final By RedMessage = By.xpath("//span[@class='text-danger']");


    public Departments(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("Clicking on Department name to navigate to edit department page")
    public Departments ClickOnDepartmentName(){
        bot.click(DepartmentName);
        return this;
    }

    @Step("Clicking on 'Edit Department Button'")
    public Departments ClickOnEdit(){
        bot.click(EditDepartmentButton);
        return this;
    }

    @Step("Editing the Department name")
    public Departments EditTheDepartmentName(){
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField,  Keys.DELETE+"NameForTesting");
        return this;
    }

    @Step("Editing the Department name")
    public Departments LeaveTheDepartmentNameEmpty(){
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField,  Keys.CONTROL + "a");
        bot.type(DepartmentNameField,  Keys.DELETE);
        //bot.type(DepartmentNameField,  Keys.ENTER);
        return this;
    }

    @Step("Editing the Department type")
    public Departments EditTheDepartmentType(){
        //bot.click(DepartmentTypeSelect);
        bot.type(DepartmentNameFieldSelector,"Team"+Keys.ENTER);
        return this;
    }

    @Step("Clicking On Save Button")
    public Departments ClickingOnSaveButton(){
        bot.click(SaveButton);
        return this;
    }

    @Step("Getting the message")
    public Departments GetTheMessage() {
        bot.getText(Message);
        return this;
    }



    @Step("Getting the message")
    public Departments GetTheRedMessage() {
        bot.getText(RedMessage);
        return this;
    }
}
