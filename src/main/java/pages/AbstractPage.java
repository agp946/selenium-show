package pages;

import classes.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {

    protected static final Logger log = Logger.getLogger(AbstractPage.class);

    public abstract void hasOpened();

}
