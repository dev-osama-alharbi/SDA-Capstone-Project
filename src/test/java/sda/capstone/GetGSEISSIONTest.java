package sda.capstone;

import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;

public class GetGSEISSIONTest extends TestBase{

    @Test
    public void getGSEISSIONTest(){
        String GSEISSION = new StartPage(driver,bot,wait)
                .goTo()
                .clickLoginButton()
                .login(username,password)
                .getGSEISSION();

        System.out.println("GSEISSION => "+GSEISSION);
    }
}
