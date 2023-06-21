package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import helpers.BrowserProvider;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import pages.components.PopUpSinscrire;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.util.UUID;

public class BaseTest {

    public Playwright playwright;
    public Browser browser;
    public Page page;
    protected HomePage homePage;
    protected PopUpSinscrire popUpSinscrire;
    protected ManuelGeographie manuelGeographie;
    private BrowserProvider browserProvider = new BrowserProvider();

    @BeforeMethod
    @Parameters({"browserName"})
    public void set(@Optional("Firefox") String browserName) {
        playwright = Playwright.create();
        browser = browserProvider.getBrowser(playwright, browserName)
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.lelivrescolaire.fr/page/53729234");
        homePage = new HomePage(page);
        popUpSinscrire= new PopUpSinscrire(page);
        manuelGeographie = new ManuelGeographie(page);
        Assert.assertNotNull(page);
    }

    @AfterMethod
    public void close(ITestResult result) {
        if (!result.isSuccess()) {
            String uuid = UUID.randomUUID().toString();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("allure-results/screenshot" + uuid + "screenshot.png"))
                    .setFullPage(true));
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(screenshot));
        }
//        browser.close();
    }

}