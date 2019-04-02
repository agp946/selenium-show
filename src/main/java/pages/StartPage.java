package pages;

import classes.Browser;
import classes.WebElementEx;
import org.openqa.selenium.WebElement;

public class StartPage extends AbstractPage {

    public void hasOpened() {
        log.info("Открывается страница входа...");
        btnSignIn().waitForPrecence();
        log.info("Открыта страница входа");
    }

    public WebElementEx btnSignIn(){
        return new WebElementEx("//a[@href='/app/sign-in-company']");
    }
}
