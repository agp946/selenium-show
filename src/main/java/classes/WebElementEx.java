package classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.io.File;

import static classes.Browser.getAttributeValue;

public class WebElementEx {

    private static final Logger log = Logger.getLogger(Browser.class);

    WebElement element;
    String locator;

    public WebElementEx(String locator){
        this.locator=locator;
    }

    public void click(){
        log.info("Нажимаем на элемент:" + locator);
        Browser.getElement(locator).click();
    }

    public void clear(){
        log.info("Очищаем текст в элементе: "+locator);
        Browser.getElement(locator).clear();
    }

    public void sendKeys(String text){
        log.info("Вводим текст: '" + text+ "' в элемент: "+locator);
        Browser.getElement(locator).sendKeys(text);
    }

    public void hasAppeared(){
        log.info("Отобразился элемент:" + locator);
        Browser.waitForPrecence(locator);
    }

    public void hasAppeared(int timeout){
        log.info("Отобразился элемент:" + locator);
        Browser.waitForPrecence(locator, timeout);
    }

    public void hasAttributeEquals(String attributeName, String value) throws Exception {
        log.info("Атрибут элемента:" + locator+ " содержит значение: " +value);
        String realvalue = getAttributeValue(locator,attributeName);
        if (!value.equals(realvalue))
            throw new Exception("Значение атрибута не соответствует "+value+ " Фактическое значение "+realvalue);
    }

    public void inputFile(String fileName) throws Exception {
        File file = new File(Application.TEST_DATA_PATH+fileName);
        log.info("Загружаем файл:" + file.getAbsolutePath());
        if (!file.exists()){
            log.error("Не найден файл "+file.getAbsolutePath());
            throw new Exception("Не найден файл "+file.getAbsolutePath());
        }
        Browser.getElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void waitForPrecence(){
        Browser.waitForPrecence(locator);
    }

    public void waitForPrecence(int timeout){
        Browser.waitForPrecence(locator, timeout);
    }
}
