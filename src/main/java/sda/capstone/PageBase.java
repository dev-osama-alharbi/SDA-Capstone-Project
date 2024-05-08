package sda.capstone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class PageBase {
    public final WebDriver driver;
    public final ActionsBot bot;
    public final Wait<WebDriver> wait;

    public PageBase(WebDriver driver, ActionsBot bot,Wait<WebDriver> wait){
        this.driver=driver;
        this.bot=bot;
        this.wait=wait;
    }
}
