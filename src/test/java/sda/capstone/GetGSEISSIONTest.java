package sda.capstone;

import org.testng.annotations.Test;
import sda.capstone.Pages.StartPage;
import sda.capstone.UI.UITestBase;

public class GetGSEISSIONTest extends UITestBase {

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
