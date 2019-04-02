package pages;


import classes.Browser;
import classes.WebElementEx;

public class AddLogoPage extends AbstractPage {

    public void hasOpened() {
        log.info("Открывается страница 'Добавить логотип компани'...");
        logoDropZone().waitForPrecence(20);
        log.info("Открыта страница 'Добавить логотип компани'");
    }

    public WebElementEx btnContinue(){return new WebElementEx("//button[contains(.,'Continue')]"); }

    public WebElementEx logoDropZone() {return new WebElementEx("//div[@class='form-dropzone form-dropzone-photo']");}

    public WebElementEx fileInput() {return new WebElementEx("//input[@name='file']");}

    public WebElementEx logoPreview() {return new WebElementEx("//div[@class='form-dropzone-preview']");}


}
