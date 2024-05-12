package sda.capstone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class Pages {
    final public WebDriver driver;
    final public ActionsBot bot;
    final public Wait<WebDriver> wait;

    public Pages(WebDriver driver, ActionsBot bot,Wait<WebDriver> wait){
        this.driver=driver;
        this.bot=bot;
        this.wait=wait;
    }
}
