package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.PropertiesReader;


public class RemoteUnitsPage extends PageBase {

    public RemoteUnitsPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot,wait);
    }
    private final String url = PropertiesReader.props.getProperty("baseUrlAfterLogin") + "departments/remote";
    private final By addNewRemoteUnitButton = By.xpath("//button[contains(., 'Add New Remote Unit')]");

//    private final By editRemoteUnit = By.xpath("//b[contains(., 'editTeam4Test')]");


    @Step("Given I am on the Remote Units page")
    public RemoteUnitsPage goTo() {
        bot.navigate(url);
        return this;
    }

    @Step("When I click the add new remote unit button, I will be directed to the New Remote Unit page")
    public RemoteUnitsPage goToAddNewRemoteUnit() {
        bot.click(addNewRemoteUnitButton);
        return this;
    }


//    @Step("Clicking on Remote Unit to navigate to edit Remote Units page")
//    public RemoteUnits goToEditNewRemoteUnit(){
//        bot.click(editRemoteUnit);
//        return this;
//    }






}
