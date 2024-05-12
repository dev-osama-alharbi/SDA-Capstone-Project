package sda.capstone.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import sda.capstone.ActionsBot;
import sda.capstone.PageBase;
import sda.capstone.impl.AssertStringTestImpl;

public class HomePage extends PageBase {

    private final By validLogin = By.xpath("//h4[contains(text(), 'Profile')]");
    private final By logoImageLink = By.xpath("//a[contains(@class, 'navbar')]");
    private final By sideBarList=By.xpath("//ul[contains(@class, 'SidebarLinkList')]");
    private final By logoImage = By.xpath("//img[@alt='Logo']");
    private final By homepageText= By.xpath("//a[text()='Home']");
    private final By profilePageBy = By.cssSelector("#link0 a");
    private final By mySubscriptionPageBy = By.cssSelector("#link1 a");
    private final By myMembershipsPageBy = By.cssSelector("#link2 a");
    private final By companyGroupPageBy = By.cssSelector("#link3 a");
    private final By companyPageBy = By.cssSelector("#link4 a");
    private final By departmentsPageBy = By.cssSelector("#link5 a");
    private final By remoteUnitsPageBy = By.cssSelector("#link6 a");
    private final By teamsPageBy = By.cssSelector("#link7 a");
    private final By usersPageBy = By.cssSelector("#link8 a");
    private final By rolesPageBy = By.cssSelector("#link9 a");
    private final By permissionsPageBy = By.cssSelector("#link10 a");
    private final By accessTokensPageBy = By.cssSelector("#link11 a");

    public By dropdownText = By.xpath("//td[contains(@class, 'text-start')]");

    public String username = "t4@testevolve.com";

    public String role ="Business Owner";
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

    @Step ("go To Profile Page")
    public ProfilePage goToProfilePage() {
        bot.click(profilePageBy);
        return new ProfilePage(driver,bot,wait);
    }

    @Step ("go To My Subscription Page")
    public void goToMySubscriptionPage() {
        bot.click(mySubscriptionPageBy);
        //TODO return page class
    }

    @Step ("go To My Memberships Page")
    public MyMembershipsPage goToMyMembershipsPage() {
        bot.click(myMembershipsPageBy);
        return new MyMembershipsPage(driver,bot,wait);
    }

    @Step ("go To My Company Group Page")
    public void goToCompanyGroupPage() {
        bot.click(companyGroupPageBy);
        //TODO return page class
    }

    @Step ("go To Company Page")
    public CompanyPage goToCompanyPage() {
        bot.click(companyPageBy);
        return new CompanyPage(driver,bot,wait);
    }

    @Step ("go To Departments Page")
    public void goToDepartmentsPage() {
        bot.click(departmentsPageBy);
        //TODO return page class
    }

    @Step ("go To Remote Units Page")
    public void goToRemoteUnitsPage() {
        bot.click(remoteUnitsPageBy);
        //TODO return page class
    }

    @Step ("go To Teams Page")
    public void goToTeamsPage() {
        bot.click(teamsPageBy);
        //TODO return page class
    }

    @Step ("go To Users Page")
    public void goToUsersPage() {
        bot.click(usersPageBy);
        //TODO return page class
    }

    @Step ("go To Roles Page")
    public void goToRolesPage() {
        bot.click(rolesPageBy);
        //TODO return page class
    }

    @Step ("go To Permissions Page")
    public void goToPermissionsPage() {
        bot.click(permissionsPageBy);
        //TODO return page class
    }

    @Step ("go To Access Tokens Page")
    public void goToAccessTokensPage() {
        bot.click(accessTokensPageBy);
        //TODO return page class
    }

    @Step("And when I click on my photo, I will see the DropDown menu")
    public void clickOnUserPhoto() {
        wait.until(f -> {
            driver.findElement(dropdownText).isDisplayed();
            return true;
        });
        bot.click(dropdownText);
    }

    @Step("And I will see my username written beside my photo")
    public boolean getTheUsernameTextFromTheDropdown(){
        return bot.getText(dropdownText).contains(username);
    }

    @Step("And I will see my role written beside my username")
    public boolean getTheRoleTextFromTheDropdown(){
        return bot.getText(dropdownText).contains(role);
    }

}
