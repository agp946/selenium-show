package pages;

import classes.Browser;
import classes.WebElementEx;

public class CompanyProfilePage extends AbstractPage {

    public void hasOpened() {
        companyHeader().waitForPrecence();
    }

    public void hasOpened(String companyName) {
        companyHeaderTitle(companyName).waitForPrecence();
    }

    public WebElementEx companyHeader(){
        return new WebElementEx("//revet-company-profile-header");
    }

    public WebElementEx companyHeaderTitle(String companyName){
        return new WebElementEx("//revet-company-profile-header//h1[contains(.,'"+companyName+"')]");
    }

}
