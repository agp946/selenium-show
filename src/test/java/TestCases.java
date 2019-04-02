import classes.Browser;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

public class TestCases {
    private static final Logger log = Logger.getLogger(TestCases.class);

    @BeforeClass
    public static void setup(){
        log.info("//// Запускаем тесты");
        Browser.init();
    }

    @AfterClass
    public static void endtests(){
        Browser.dispose();
        log.info("//// Тесты завершены");
    }

    @Test
    public void registration() throws Exception {

        StartPage startPage = new StartPage();
        SignInPage signInPage = new SignInPage();
        JoinNowPage joinNowPage = new JoinNowPage();
        TellAboutYouPage tellAboutYouPage = new TellAboutYouPage();
        AddLogoPage addLogoPage = new AddLogoPage();
        ProfileIsReadyPage profileIsReadyPage = new ProfileIsReadyPage();
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();

        Browser.open("https://dev2.revetinc.com/");
        startPage.hasOpened();
        startPage.btnSignIn().click();
        signInPage.hasOpened();
        signInPage.linkJoinNow().click();
        joinNowPage.hasOpened();
        joinNowPage.inputFirstName().sendKeys("First Name");
        joinNowPage.inputLastName().sendKeys("Last Name");
        //joinNowPage.inputEMail().sendKeys("address@example.com");
        joinNowPage.typeRandomEMailAddress();
        joinNowPage.inputPassword().sendKeys("Aa12345!");
        joinNowPage.btnJoinNow().click();
        tellAboutYouPage.hasOpened();
        tellAboutYouPage.inputCompanyName().sendKeys("Компания, Inc");
        tellAboutYouPage.multiSelectSelect("country", "Russian Federation");
        tellAboutYouPage.inputPostalCode().sendKeys("000000");
        tellAboutYouPage.multiSelectSelect("industry", "Software Publishers (except Internet)");
        tellAboutYouPage.btnContinue().click();
        addLogoPage.hasOpened();
        addLogoPage.fileInput().inputFile("siluet.jpg");
        addLogoPage.btnContinue().click();
        profileIsReadyPage.hasOpened();
        profileIsReadyPage.linkGoToProfile().click();
        companyProfilePage.hasOpened("Компания, Inc");

    }
}
