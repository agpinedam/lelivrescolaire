package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MenuComponent extends BasePage {

    private final Locator sInscrire;

    private final Logger log = LoggerFactory.getLogger(pages.HomePage.class);

    public MenuComponent(Page page) {
        super(page);
        sInscrire = page.locator("text= S'inscrire");
    }

    @Step("Click on S'inscrire")
    public void clickOnCreateNewAccount() {
        assertIfLocatorIsVisible(sInscrire);
        sInscrire.hover();
        sInscrire.click();
        log.info("Click on S'incrire button");
    }
}