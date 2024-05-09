package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class DepartmentsPage extends PageBase {

    private final By DepartmentLink = By.xpath("//a[@href='#/departments/department']");
    private final By DepartmentName = By.cssSelector(".card-text > div > div > a > b");
    private final By EditDepartmentButton = By.xpath("//button[contains(text(),'Edit')]");
    private final By DepartmentNameField = By.id("name");
    private final By DepartmentTypeDropDown = By.xpath("(//input[@role='combobox'])[1]");
    private final By SaveButton = By.xpath("//button[text()='Save']");
    private final By SuccessMessage = By.cssSelector(".toaster > div > div > p");
    private final By FailureMessage = By.xpath("//span[@class='text-danger']");
    private final By DeleteTheDepartmentButton = By.xpath("//button[contains(text(),'Delete')]");
    private final By ConfirmTheDeletion = By.xpath("//button[contains(text(),'Confirm')]");
    private final By DepartmentProof = By.xpath("//div[@class='col' and h3='Departments']");


    public DepartmentsPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot,wait);
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

    @Step("Clicking on Department Link to navigate to Department Page")
    public DepartmentsPage goTo(){
        WaitFor(DepartmentLink);
        bot.click(DepartmentLink);
        return this;
    }

    @Step("Clicking on Department name to navigate to edit department page")
    public DepartmentsPage ClickOnDepartmentName(){
        bot.click(DepartmentName);
        return this;
    }

    @Step("Clicking on 'Edit Department' Button")
    public DepartmentsPage ClickOnEdit(){
        WaitFor(EditDepartmentButton);
        bot.click(EditDepartmentButton);
        return this;
    }

    @Step("Editing the Department name to 'NameForTesting' ")
    public DepartmentsPage EditTheDepartmentName(){
        WaitFor(DepartmentNameField);
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField,  Keys.DELETE+"NameForTesting");
        return this;
    }

    @Step("Leaving the Department name empty")
    public DepartmentsPage LeaveTheDepartmentNameEmpty(){
        WaitFor(DepartmentNameField);
        driver.findElement(DepartmentNameField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(DepartmentNameField).sendKeys(Keys.DELETE);
        return this;
    }

    @Step("Editing the Department type to 'Team' ")
    public DepartmentsPage EditTheDepartmentType(){
        WaitFor(DepartmentTypeDropDown);
        bot.type(DepartmentTypeDropDown , "Team"+Keys.ENTER);
        return this;
    }

    @Step("Leaving the Department type empty")
    public DepartmentsPage LeaveTheDepartmentTypeEmpty(){
        WaitFor(DepartmentTypeDropDown);
        bot.click(DepartmentTypeDropDown);
        bot.type(DepartmentTypeDropDown , Keys.DELETE);
        return this;
    }

    @Step("Clicking On Save Button")
    public DepartmentsPage ClickingOnSaveButton(){
        bot.click(SaveButton);
        return this;
    }

    @Step("Getting the success message")
    public String GetTheSuccessMessage() {
        wait.until(d -> driver.findElement(SuccessMessage).isDisplayed());
        return bot.getText(SuccessMessage);
    }



    @Step("Getting the failure message")
    public String GetTheFailureMessage() {
        wait.until(d -> driver.findElement(FailureMessage).isDisplayed());
        return bot.getText(FailureMessage);
    }

    @Step("Deleting the department")
    public String DeleteTheDepartment() {
        WaitFor(DeleteTheDepartmentButton);
        bot.click(DeleteTheDepartmentButton);
        wait.until(d -> driver.findElement(ConfirmTheDeletion).isDisplayed());
        bot.click(ConfirmTheDeletion);
        WaitFor(DepartmentProof);
        return bot.getText(DepartmentProof);
    }
}
