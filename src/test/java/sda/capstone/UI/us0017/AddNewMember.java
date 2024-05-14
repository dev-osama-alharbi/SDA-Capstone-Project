package sda.capstone.UI.us0017;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.capstone.TestBase;
import sda.capstone.Pages.*;

public class AddNewMember extends TestBase {

    private final By login = By.xpath("//a[@class='login-button']");
    private final By name = By.id("username");
    private final By pass = By.id("password");
    private final By sign = By.xpath("//button[@type='submit']");

    @Step("test vaild email")
    @Test
    public void UsersTestVaildEmail() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/users");

        bot.type(name, username);
        bot.type(pass, password);
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/users");

        Users users = new Users(driver, bot,wait);
        String text = users.ClickOnAddNewMember()
                .selectDepartment("") // Assuming department selection method exists in Users class
                .enterEmail( "email_"+ System.currentTimeMillis() + "@gmail.com")
                .ClickOnRole()
                .ClickOnRegister()
                .GetTheSucess();
        Assert.assertEquals(text, "Successful");
    }

    @Step("Testing the invaild email ")
    @Test
    public void UsersTestInvaildEmail() {
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/users");
        bot.type(name, username);
        bot.type(pass, password);
        bot.click(sign);
        bot.navigate("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/users");

        Users users = new Users(driver, bot,wait);

        String text = users.ClickOnAddNewMember()
                .selectDepartment("sda") // Assuming department selection method exists in Users class
                .enterEmail("email_"+ System.currentTimeMillis() + "gmail.com")
                .ClickOnRole() // Click role selection if applicable
                .ClickOnRegister()
                .GetTheError();
        Assert.assertEquals(text, "Please enter a valid email");
    }



    public AddNewMember selectDepartment(String departmentName) {
        bot.type(By.id("react-select-4-input"), departmentName);
        return this;
    }

    public AddNewMember enterEmail(String email) {
        bot.type(By.id("email"), email);
        return this;
    }
}