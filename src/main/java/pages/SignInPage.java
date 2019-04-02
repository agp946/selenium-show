package pages;

import classes.Browser;
import classes.WebElementEx;

public class SignInPage extends AbstractPage {

    public void hasOpened() {
        log.info("Открывается страница авторизации...");
        btnSignIn().waitForPrecence(20);
        log.info("Открыта страница авторизации");
    }

    public WebElementEx btnSignIn(){
        return new WebElementEx("//button[contains(.,'Sign In')]");
    }

    public WebElementEx inputEMail(){
        return new WebElementEx("//input[@name='emailAddress']");
    }

    public WebElementEx inputPassword(){
        return new WebElementEx("//input[@name='password']");
    }

    public WebElementEx linkJoinNow(){
        return new WebElementEx("//a[@href='/app/join-now-company']");
    }


}
