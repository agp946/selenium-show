package pages;

import classes.Browser;
import classes.WebElementEx;

public class TellAboutYouPage extends AbstractPage {

    public void hasOpened() {
        btnContinue().waitForPrecence();
    }

    public WebElementEx inputCompanyName(){
        return new WebElementEx("//input[@name='companyName']");
    }

    public WebElementEx inputPostalCode(){
        return new WebElementEx("//input[@name='zipCode']");
    }

    public WebElementEx inputDescription(){
        return new WebElementEx("//textarea[@name='description']");
    }

    public WebElementEx mulSelect(String name){
        return new WebElementEx("//multiple-select[@name='"+name+"']/div[@class='multiple-select']");
    }

    public WebElementEx mulSelectOptions(String name){
        return new WebElementEx("//multiple-select[@name='"+name+"']/div/div[contains(@class,'multiple-select-options')]");
    }

    public WebElementEx mulSelectOption(String name, String optionName){
        return new WebElementEx("//multiple-select[@name='"+name+"']/div/div[contains(@class,'multiple-select-options')]//button/span[contains(.,'"+optionName+"')]");
    }

    public WebElementEx mulSelectSearchInput(String name){
        return new WebElementEx("//multiple-select[@name='"+name+"']/div/label/input");
    }

    public WebElementEx btnContinue(){
        return new WebElementEx("//button[contains(.,'Continue')]");
    }

    public void multiSelectSelect(String msName, String optionName) throws Exception {
        mulSelect(msName).click();
        mulSelectOptions(msName).waitForPrecence();
        mulSelectSearchInput(msName).sendKeys(optionName);
        mulSelectOption(msName,optionName).waitForPrecence();
        mulSelectOption(msName,optionName).click();
        mulSelectSearchInput(msName).hasAttributeEquals("placeholder", optionName);
    }
}
