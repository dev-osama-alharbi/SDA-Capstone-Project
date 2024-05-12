package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class EditRemoteUnitPage extends PageBase {

    public EditRemoteUnitPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    private final By remoteUnitNameInput = By.xpath("//input[@id='name']");
    private final By departmentTypeDropDown  = By.xpath("//input[@role='combobox']");
    private final By saveButton = By.xpath("//button[contains(@class,'btn-info')]");
    private final By errorMSGLabel = By.xpath("//span[@class='text-danger']");
    private final By successfullyMSGLabel =  By.cssSelector(".toaster > div > div > p");
    private final By deleteDepartmentButton =  By.xpath("//button[contains(@class,'btn-danger')]");
    private final By confirmButton =  By.xpath("//button[@class='btn btn-danger']");

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

    @Step("Edit the remote unit name")
    public EditRemoteUnitPage editRemoteName(String name){
        if (name != null) {
            WaitFor(remoteUnitNameInput);
            bot.type(remoteUnitNameInput,name+ Keys.ENTER);
        }else {
            WaitFor(remoteUnitNameInput);
            driver.findElement(remoteUnitNameInput).sendKeys(Keys.CONTROL + "a");
            driver.findElement(remoteUnitNameInput).sendKeys(Keys.DELETE);
        }
        return this;
    }

    @Step("Edit the remote unit type")
    public EditRemoteUnitPage editRemoteType(String type){
        if (type != null) {
            WaitFor(departmentTypeDropDown);
            bot.click(departmentTypeDropDown);
            bot.type(departmentTypeDropDown , type+Keys.ENTER);
        }else{
            WaitFor(departmentTypeDropDown);
            bot.click(departmentTypeDropDown);
            bot.type(departmentTypeDropDown,Keys.CONTROL+"a"+Keys.DELETE);
        }
        return this;
    }

    @Step("Clicking on save button to edit a remote unit")
    public EditRemoteUnitPage clickingOnSaveButton(){
        bot.click(saveButton);
        return this;
    }

    @Step("Getting the successfully message when edit remote unit adding")
    public String successfullyMSG(){ return bot.getText(successfullyMSGLabel); }

    @Step("Getting the error message when name or type empty")
    public String errorMSG(){return bot.getText(errorMSGLabel);}



    @Step("Clicking on delete button to delete a remote unit")
    public EditRemoteUnitPage clickOnDeleteButton(){
        WaitFor(deleteDepartmentButton);
        bot.click(deleteDepartmentButton);
        return this;
    }

    @Step("Clicking on confirm button to delete a remote unit")
    public EditRemoteUnitPage clickOnConfirmButton(){
        wait.until(f -> {
        driver.findElement(confirmButton).isDisplayed();
        return true;
    });
        bot.click(confirmButton);
        return this;
    }





}




