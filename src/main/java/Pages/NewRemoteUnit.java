package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import sda.capstone.ActionsBot;
import sda.capstone.Pages;

public class NewRemoteUnit extends Pages {

    public NewRemoteUnit(WebDriver driver, ActionsBot bot) {super(driver, bot); }

    private final By RemoteUnitName = By.xpath("//input[@id='name']");
    private final By dropdown  = By.xpath("//input[@role='combobox']");
    private final By RemoteUnitType  = By.xpath("//div[contains(text(), 'Remote Unit')]");
    private final By SaveButton  = By.xpath("//button[contains(text(), 'Save')]");
    final By ErrorMSGName  = By.xpath("//span[contains(text(), 'Please enter a name for department')]");
    private final By ErrorMSGType = By.xpath("//span[contains(text(), 'Please select a type for department')]");

    private final By successfullyMSG  =  By.cssSelector(".toaster > div > div > p");


    @Step("adding remote name")
    public NewRemoteUnit addRemoteName(String name){
        if (name != null) {
            bot.type(RemoteUnitName, name);
        }
        return this;
    }

    @Step("adding remote type")
    public NewRemoteUnit addRemoteType(String type){
        if (type != null) {
            bot.click(dropdown);
            bot.click(RemoteUnitType);
        }
        return this;
    }


    @Step("Clicking On Save Button")
    public NewRemoteUnit ClickingOnSaveButton(){
        bot.click(SaveButton);
        return this;
    }

    @Step("Getting the successfully message when new remote unit adding ")
    public String successfullyMSG(){
        return bot.getText(successfullyMSG);
    }

    @Step("Getting the error message when name is empty")
    public String ErrorMSGName(){
        return  bot.getText(ErrorMSGName);

    }

    @Step("Getting the error message when type is empty")
    public String ErrorMSGType(){
        return  bot.getText(ErrorMSGType);
    }









}
