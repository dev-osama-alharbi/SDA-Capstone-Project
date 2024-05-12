package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.PropertiesReader;


public class RemoteUnitPage extends PageBase {

    public RemoteUnitPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot,wait);
    }
    private final String url = PropertiesReader.props.getProperty("baseUrlAfterLogin") + "departments/remote";
    private final By addNewRemoteUnitButton = By.xpath("//button[contains(., 'Add New Remote Unit')]");
    private final By selectRemoteUnit = By.cssSelector(".card-text > div > div > a > b");
    private final By editRemoteUnitButton = By.xpath("//button[contains(text(),'Edit')]");





    @Step("Given I am on the Remote Units page")
    public RemoteUnitPage goTo() {
        bot.navigate(url);
        return this;
    }

    @Step("When I click the add new remote unit button, I will be directed to the New Remote Unit page")
    public RemoteUnitPage goToAddNewRemoteUnit() {
        bot.click(addNewRemoteUnitButton);
        return this;
    }
    @Step("Select a remote unit to edit, and click it")
    public RemoteUnitPage selectARemoteUnitToEdit(){
        bot.click(selectRemoteUnit);
        return this;
    }
    @Step("Clicking on edit Remote Unit to navigate to edit Remote Unit page")
    public RemoteUnitPage clickEditRemoteUnitButton(){
        bot.click(editRemoteUnitButton);
        return this;
    }








}
