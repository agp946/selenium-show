package classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Browser {
    private static final Logger log = Logger.getLogger(Browser.class);

    private static final String WEB_DRIVER_PATH="resources/drivers/geckodriver.exe";
    private static final int TIME_OUT =10;

    private static WebDriver driver;

    public static void init() {
        try {
            log.info("Инициализация драйвера...");
            System.setProperty("webdriver.gecko.driver", WEB_DRIVER_PATH);
            driver = new FirefoxDriver();
            //driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
            if (driver==null)
                throw new Exception("Не удалось инициализировать драйвер");
            log.info("Инициализирован драйвер");
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public static void dispose(){
        driver.close();
    }

    public static void open(String url){
        log.info("Открываем url: "+url);
        driver.get(url);
    }

    public static WebElement waitForPrecence(String locator){
        return waitForPrecence(locator, TIME_OUT);
    }

    public static WebElement waitForPrecence(String locator, int timeout){
        WebDriverWait waitDriver = new WebDriverWait(driver, timeout);
        WebElement result;
        try {
            log.debug("Ожидаем появление элемента "+locator+" ...");
            result=waitDriver.until(presenceOfElementLocated(By.xpath(locator)));
            log.debug("Появился элемент "+locator);
            return result;
        } catch (TimeoutException e){
            log.error(e.getMessage());
            throw e;
        }
    }

    public static WebElement getElement(String locator){
        WebElement result;
        try {
            log.debug("Поиск на странице элемента "+locator+" ...");
            result = driver.findElement(By.xpath(locator));
            log.debug("Найден элемент "+locator);
            return result;
        } catch (NoSuchElementException e){
            log.error("Не найден элемент "+locator);
            throw e;
        }
    }

    public static String getAttributeValue(String locator, String attributeName){
        WebElement result;
        String attributeValue;
        try {
            log.debug("Поиск на странице элемента: "+locator+" ...");
            result = driver.findElement(By.xpath(locator));
            log.debug("Получаем значение атрибута "+attributeName+" ...");
            attributeValue = result.getAttribute(attributeName);
            log.debug("Найден элемент "+locator+ "с атрибутом "+ attributeName+ " равным "+attributeValue);
            return attributeValue;
        } catch (NoSuchElementException e){
            log.error("Не найден элемент "+locator);
            throw e;
        }
    }

}
