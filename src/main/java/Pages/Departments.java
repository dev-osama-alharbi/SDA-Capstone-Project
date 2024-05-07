package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.capstone.ActionsBot;
import sda.capstone.Pages;

import java.time.Duration;

public class Departments  extends Pages {

    private final By DepartmentName = By.xpath("//b[text()='NameForTesting']");
    private final By EditDepartmentButton = By.xpath("//button[contains(text(),'Edit')]");
    private final By DepartmentNameField = By.id("name");
    private final By DepartmentTypeDropDown = By.xpath("(//input[@role='combobox'])[1]");
    private final By SaveButton = By.xpath("//button[text()='Save']");
    private final By SuccessMessage = By.cssSelector(".toaster > div > div > p");
    private final By xMark = By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[1]");
    private final By FailureMessage = By.xpath("//span[@class='text-danger']");


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
        bot.type(DepartmentNameField,Keys.CONTROL+"a"+Keys.DELETE);
        return this;
    }

    @Step("Editing the Department type")
    public Departments EditTheDepartmentType(){
        bot.type(DepartmentTypeDropDown , "Team"+Keys.ENTER);
        return this;
    }

    @Step("Editing the Department type")
    public Departments LeaveTheDepartmentTypeEmpty(){
        bot.click(DepartmentTypeDropDown);
        bot.type(DepartmentTypeDropDown , Keys.DELETE);
        //bot.click(xMark);
        return this;
    }

    @Step("Clicking On Save Button")
    public Departments ClickingOnSaveButton(){
        bot.click(SaveButton);
        return this;
    }

    @Step("Getting the message")
    public String GetTheSuccessMessage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(SuccessMessage).isDisplayed());
        return bot.getText(SuccessMessage);
    }



    @Step("Getting the message")
    public String GetTheRedMessage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(FailureMessage).isDisplayed());
        return bot.getText(FailureMessage);
    }
}
