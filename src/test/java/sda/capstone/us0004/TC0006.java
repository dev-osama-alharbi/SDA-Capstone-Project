package sda.capstone.us0004;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import sda.capstone.TestBase;

//US04TC06EditProfileWithValidPasswordTest
public class TC0006 extends TestBase {
    private String username = "t4@testiva.com";
    private String usernameChanged = "t4@testiva.com";
    private String password = "Z6TkqEfKvDaUd-Y";
    private String passwordChanged = "Z6TkqEfKvDaUd-Y";
    @Test
    @Step("TC_0007: Passwords: uppercase (A-Z), lowercase (a-z), numbers (0-9), and .@#$%_&.")
    public void passwordNotConstraintsTest(){
        //TODO without uppercase (A-Z)
        passwordNotContainUppercaseLetterTest();
        //TODO without lowercase (a-z)
        passwordNotContainLowercaseLetterTest();
        //TODO without numbers (0-9)
        passwordNotContainDigitTest();
        //TODO without .@#$%_&.
        passwordNotSpecialCharactersTest();
        //TODO passwordLimitCharactersTest
        passwordLimitCharactersTest();
    }

    @Step("Password must be between 8 to 20 characters long")
    public void passwordLimitCharactersTest(){
        //TODO less than 8
        //TODO bigger than 20
    }

    @Step("Password must contain at least one uppercase")
    public void passwordNotContainUppercaseLetterTest(){
        //TODO passwordNotContainUppercaseLetter
    }

    @Step("Password must contain at least one lowercase")
    public void passwordNotContainLowercaseLetterTest(){
        //TODO passwordNotContainLowercaseLetter
    }

    @Step("Password must contain at least one digit")
    public void passwordNotContainDigitTest(){
        //TODO passwordNotContainDigit
    }

    @Step("Password must contain special characters from .@#$%_&")
    public void passwordNotSpecialCharactersTest(){
        //TODO passwordNotSpecialCharactersTest
    }
}
