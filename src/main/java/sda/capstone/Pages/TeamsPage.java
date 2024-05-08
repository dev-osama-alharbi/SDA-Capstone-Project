package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

import java.util.List;

public class TeamsPage extends PageBase {


    private final By teamsModuleSidebarLocator = By.xpath("//a[@href='#/departments/team']");
    private final By teamContainerLocator = By.cssSelector("div>div>div>div>div>div>div.row");
    private final By teamElementLocator = By.xpath("//a[contains(@href,'#/department/1')]");
    private final String teamName = "SDA-Team4";
    private final By selectedTeamElement = By.linkText(teamName);


    public TeamsPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) { //⬅️
        super(driver, bot, wait);
    }


    public TeamsPage navigateToTeamModule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamsModuleSidebarLocator));
        bot.click(teamsModuleSidebarLocator);
        return this;
    }

    @Step("When I get team elements as list")
    public List<WebElement> getTeamElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamContainerLocator));
        WebElement teamContainer = driver.findElement(teamContainerLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamElementLocator));
        List<WebElement> teamElements = teamContainer.findElements(teamElementLocator);
        return teamElements;
    }

    @Step("Then team is displayed")
    public boolean isTeamDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedTeamElement));
        return driver.findElement(selectedTeamElement).isDisplayed();
    }

    @Step("Then team is clickable")
    public boolean isTeamClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(selectedTeamElement)) != null;
    }

}
