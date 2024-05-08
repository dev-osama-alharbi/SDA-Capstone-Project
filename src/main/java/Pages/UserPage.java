package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class UserPage {
    private final WebDriver driver;
    private By usersListLocator = By.xpath("//tbody[@class='tableRows']//tr//td[2]//a");

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getUsers() {
        return driver.findElements(usersListLocator).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
