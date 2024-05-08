package sda.capstone;

import org.openqa.selenium.WebDriver;

public class Pages {
    final public WebDriver driver;
    final public ActionsBot bot;

    public Pages(WebDriver driver, ActionsBot bot){
        this.driver=driver;
        this.bot=bot;
    }
}