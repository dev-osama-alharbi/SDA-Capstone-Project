package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.testng.SkipException;
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

    @Step("Given I am on the Department Page")
    public DepartmentsPage goTo(){
        WaitFor(DepartmentLink);
        bot.click(DepartmentLink);
        return this;
    }

    @Step("When I click on the department name, I will be directed to the edit department page")
    public DepartmentsPage ClickOnDepartmentName(){
        try{
            bot.click(DepartmentName);
        }catch (TimeoutException timeoutException){
            System.out.println("No departments found");
            throw new SkipException("Skipping this exception");
        }
        return this;
    }

    @Step("And I click on 'Edit Department' button")
    public DepartmentsPage ClickOnEdit(){
        WaitFor(EditDepartmentButton);
        bot.click(EditDepartmentButton);
        return this;
    }

    @Step("And I edit the department name to 'NameForTesting' ")
    public DepartmentsPage EditTheDepartmentName(){
        WaitFor(DepartmentNameField);
        bot.click(DepartmentNameField);
        bot.type(DepartmentNameField,  Keys.DELETE+"NameForTesting");
        return this;
    }

    @Step("And I leave the department name empty")
    public DepartmentsPage LeaveTheDepartmentNameEmpty(){
        WaitFor(DepartmentNameField);
        driver.findElement(DepartmentNameField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(DepartmentNameField).sendKeys(Keys.DELETE);
        return this;
    }

    @Step("And I edit the department type to 'Department' ")
    public DepartmentsPage EditTheDepartmentType(){
        WaitFor(DepartmentTypeDropDown);
        bot.type(DepartmentTypeDropDown , "Department"+Keys.ENTER);
        return this;
    }

    @Step("And I leave the department type empty")
    public DepartmentsPage LeaveTheDepartmentTypeEmpty(){
        WaitFor(DepartmentTypeDropDown);
        bot.type(DepartmentTypeDropDown , Keys.DELETE);
        return this;
    }

    @Step("And I click on 'Save' button")
    public DepartmentsPage ClickingOnSaveButton(){
        bot.click(SaveButton);
        return this;
    }

    @Step("Then I will see the success message")
    public String GetTheSuccessMessage() {
        wait.until(d -> driver.findElement(SuccessMessage).isDisplayed());
        return bot.getText(SuccessMessage);
    }



    @Step("Then I will see the failure message")
    public String GetTheFailureMessage() {
        wait.until(d -> driver.findElement(FailureMessage).isDisplayed());
        return bot.getText(FailureMessage);
    }

    @Step("Then I delete the department")
    public String DeleteTheDepartment() {
        WaitFor(DeleteTheDepartmentButton);
        bot.click(DeleteTheDepartmentButton);
        wait.until(d -> driver.findElement(ConfirmTheDeletion).isDisplayed());
        bot.click(ConfirmTheDeletion);
        WaitFor(DepartmentProof);
        return bot.getText(DepartmentProof);
    }
}
