package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

import java.util.List;

public class UserPage extends PageBase {

    public String username = "testevolve12@testevolve.com";
    public String password = "DJK7wyf8_ZpG464";
    private By usersListLocator = By.xpath("//tbody[@class='tableRows']//tr//td[2]//a");
    private By usersverified = By.cssSelector("td.cell svg path[fill='#08875D']");



    public UserPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public List<String> getUsers() {
        wait.until(webDriver -> !webDriver.findElements(usersListLocator).isEmpty());
        return bot.getTextList(usersListLocator);
    }

    public List<String> getverifiedusers() {
        // Assuming users are listed in a table and each row has a 'confirmed email' icon if the email is confirmed
        wait.until(webDriver -> !webDriver.findElements(usersverified).isEmpty());
        return bot.getTextList(usersverified);
    }

}
