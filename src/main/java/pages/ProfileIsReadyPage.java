package pages;

import classes.Browser;
import classes.WebElementEx;

public class ProfileIsReadyPage extends AbstractPage {

    public void hasOpened() {
        linkGoToProfile().waitForPrecence();
    }

    public WebElementEx linkGoToProfile(){
        return new WebElementEx("//a[contains(.,'or go to your company profile')]");
    }
}
