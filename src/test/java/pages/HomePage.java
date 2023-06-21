package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import helpers.CreateRandomData;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.MenuComponent;

public class HomePage extends BasePage {
    public MenuComponent menuComponent;

    private final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage(Page page) {
        super(page);
        menuComponent = new MenuComponent(page);
        log.info("Setup");
    }

}