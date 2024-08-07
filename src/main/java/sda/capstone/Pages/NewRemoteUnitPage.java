package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class NewRemoteUnitPage extends PageBase {

    public NewRemoteUnitPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    private final By remoteUnitNameInput = By.xpath("//input[@id='name']");
    private final By departmentTypeDropDown  = By.xpath("//input[@role='combobox']");
    private final By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    private final By errorMSGLabel = By.xpath("//span[@class='text-danger']");
    private final By successfullyMSGLabel =  By.cssSelector(".toaster > div > div > p");


    @Step("Add a name to the remote unit")
    public NewRemoteUnitPage addRemoteName(String name){
        bot.type(remoteUnitNameInput, name);
        return this;
    }

    @Step("Select department type as remote unit")
    public NewRemoteUnitPage selectDepartmentType (String type){
        bot.click(departmentTypeDropDown);
        bot.type(departmentTypeDropDown,type+Keys.ENTER);

        return this;
    }


    @Step("Clicking on save button to add a new remote unit")
    public NewRemoteUnitPage clickingOnSaveButton(){
        bot.click(saveButton);
        return this;
    }

    @Step("Getting the successfully message when new remote unit adding")
    public String successfullyMSG(){ return bot.getText(successfullyMSGLabel); }

    @Step("Getting the error message when name or type empty")
    public String errorMSG(){return bot.getText(errorMSGLabel);}













}
