package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

import java.util.List;
import java.util.stream.Collectors;

public class UserPage extends PageBase {
    private By usersListLocator = By.xpath("//tbody[@class='tableRows']//tr//td[2]//a");

    public UserPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public List<String> getUsers() {
        return bot.getTextList(usersListLocator);
//        return driver.findElements(usersListLocator).stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
    }

}
