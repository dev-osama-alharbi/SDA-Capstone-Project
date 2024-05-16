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
    private final By selectedTeamElement = By.linkText("SDA-Team4");
    private final By addNewTeamElement = By.cssSelector("div>div>div>a>button");


    public TeamsPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) { //⬅️
        super(driver, bot, wait);
    }


    @Step("When I navigate to teams from sidebar")
    public TeamsPage navigateToTeamModule() {
        wait.until(f -> {
            driver.findElement(teamsModuleSidebarLocator);
            return true;
        });
        bot.click(teamsModuleSidebarLocator);
        return this;
    }

    @Step("When I add new team")
    public TeamsPage addNewTeam() {
        bot.click(addNewTeamElement);
        return this;
    }

    public List<WebElement> getTeamElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamContainerLocator));
        WebElement teamContainer = driver.findElement(teamContainerLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamElementLocator));
        return teamContainer.findElements(teamElementLocator);
    }

    @Step("Then teams are displayed")
    public boolean isTeamDisplayed() {
        List<WebElement> teamElements = getTeamElements();
        wait.until(ExpectedConditions.visibilityOfAllElements(teamElements));

        return teamElements.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Then teams are clickable")
    public boolean isTeamClickable() {
        List<WebElement> teamElements = getTeamElements();
        return teamElements.stream().allMatch(teamElement ->
                wait.until(ExpectedConditions.elementToBeClickable(teamElement)) != null);
    }

    public boolean isTeamExist() {
        return new TeamsPage(driver, bot, wait)
                .getTeamElements()
                .stream()
                .map(WebElement::getText)
                .toList()
                .contains(teamName);
    }

    @Step("When I select a team")
    public TeamsPage selectTeam() {
        wait.until(f -> {
            bot.click(selectedTeamElement);
            return true;
        });
        return this;
    }

}
