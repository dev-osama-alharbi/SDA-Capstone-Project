package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sda.capstone.ActionsBot;
import sda.capstone.Pages;
import sda.capstone.PropertiesReader;


public class RemoteUnits extends Pages {

    public RemoteUnits(WebDriver driver, ActionsBot bot) {super(driver, bot); }
   private final String url = PropertiesReader.props.getProperty("baseUrlAfterLogin") + "departments/remote";

    private final By AddNewRemoteUnit = By.xpath("//button[contains(., 'Add New Remote Unit')]");
    private final By editRemoteUnit = By.xpath("//b[contains(., 'Test4Team')]");


    @Step("Clicking on Remote Units to navigate to Remote Units page")
    public RemoteUnits goTo(){
        bot.navigate(url);
        return this;
    }

    @Step("Clicking on Add New Remote Unit to navigate to New Remote Units page")
    public RemoteUnits goToAddNewRemoteUnit(){
        bot.click(AddNewRemoteUnit);
        return this;
    }

    @Step("Clicking on Remote Unit to navigate to edit Remote Units page")
    public RemoteUnits goToEditNewRemoteUnit(){
        bot.click(editRemoteUnit);
        return this;
    }






}
