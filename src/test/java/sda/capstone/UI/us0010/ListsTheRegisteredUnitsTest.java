package sda.capstone.UI.us0010;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sda.capstone.UI.UITestBase;
import sda.capstone.listener.CustomListener;
import sda.capstone.Pages.*;

import java.util.List;

@Listeners(CustomListener.class)
public class ListsTheRegisteredUnitsTest extends UITestBase {

        @Step("Testing the visibility of the registered remote units on 'Remote Unit' page")
        @Test
        public void listingTheRegisteredUnitsTest() {
            StartPage startPage = new StartPage(driver, bot, wait);

            startPage.
                    goTo().
                    clickLoginButton().
                    login(username, password);

            RemoteUnitPage remoteUnitsPage = new RemoteUnitPage(driver, bot, wait);

            List<WebElement> remoteUnits =
                    remoteUnitsPage.
                            goTo().
                            getUnitsList();

            System.out.println("There are "+remoteUnits.size()+" Remote Unit");
            System.out.println("The list of Remote Units: ");

            for (WebElement webElement : remoteUnits) {
                String name = webElement.getAttribute("textContent");
                System.out.println(name);
            }
            Assert.assertFalse(remoteUnits.isEmpty(), "No Remote Units are displayed.");
        }
    }
