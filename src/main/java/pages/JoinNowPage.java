package pages;

import classes.Browser;
import classes.WebElementEx;

import java.util.UUID;

public class JoinNowPage extends AbstractPage {

    public void hasOpened() {
        log.info("Открывается страница регистрации...");
        btnJoinNow().waitForPrecence(20);
        log.info("Открыта страница регистрации");
    }

    public WebElementEx inputFirstName(){
        return new WebElementEx("//input[@name='FirstName']");
    }

    public WebElementEx inputLastName(){
        return new WebElementEx("//input[@name='LastName']");
    }

    public WebElementEx inputEMail(){
        return new WebElementEx("//input[@name='UserName']");
    }

    public WebElementEx inputPassword(){
        return new WebElementEx("//input[@name='Password']");
    }

    public WebElementEx btnJoinNow(){
        return new WebElementEx("//button[contains(.,'Join Now')]");
    }

    public void typeRandomEMailAddress(){
        String user = UUID.randomUUID()+"@a.com";
        inputEMail().sendKeys(user);
    }
}
