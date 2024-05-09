package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;

public class HomePage extends PageBase {

    public By validLogin = By.xpath("//h4[contains(text(), 'Profile')]");

    public By logoImageLink = By.xpath("//a[contains(@class, 'navbar')]");

    By sideBarList=By.xpath("//ul[contains(@class, 'SidebarLinkList')]");

    By logoImage = By.xpath("//img[@alt='Logo']");

    By homepageText= By.xpath("//a[text()='Home']");

    public String homePageUrl = "https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/";


    public HomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }
    @Step ("Then I will Login to the Home Page successfully")
    public String checkSuccessfulLogin() {
        wait.until(f -> {
            driver.findElement(validLogin).isDisplayed();
            return true;
        });
        return bot.getText(validLogin);
    }

    @Step("When I click the Logo Image")
    public void clickOnTheLogoImage() {
        wait.until(f -> {
            driver.findElement(logoImageLink).isDisplayed();
            return true;
        });
        bot.click(logoImageLink);
    }

    @Step("Then I will navigate to the Home Page")
    public boolean checkTheFunctionalityOfTheLogoImageClick() {
        if (driver.getCurrentUrl().equals(homePageUrl)) {
            bot.getText(homepageText);
            return true;
        }
        else
            return false;
    }

    @Step ("Then I will see the Side bar on the Home Page")
    public boolean checkTheVisibilityOfTheSideBar() {
       return wait.until(f -> {
            driver.findElement(sideBarList).isDisplayed();
            return true;
        });
    }

    @Step ("Then I will see the Logo on the Home Page")
    public boolean checkTheVisibilityOfTheLogo() {
        return  wait.until(f -> {
            driver.findElement(logoImage).isDisplayed();
            return true;
        });
    }
}