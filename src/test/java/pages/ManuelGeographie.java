package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.MenuComponent;

public class ManuelGeographie extends BasePage {

    private final Locator consulterLaVersionPapierBouton;
    public MenuComponent menuComponent;
    private Page page;
    private Locator titlePage;

    private Locator firstParagraph;

    private Locator jeContribueBoutton;

    private final Logger log = LoggerFactory.getLogger(ManuelGeographie.class);

    public ManuelGeographie(Page page) {
        super(page);
        this.page = page;
        consulterLaVersionPapierBouton = page.locator(".s158wof9");
        titlePage = page.locator(".tkfq717").nth(0);
        firstParagraph = page.locator(".s46yyde");
        jeContribueBoutton = page.locator("text = Je contribue");
        menuComponent = new MenuComponent(page);
    }

    @Step("Click on le button Consulter la version papier")
    public void clickOnConsulterLaVersionPapierButton(){
        assertIfLocatorIsVisible(consulterLaVersionPapierBouton);
        consulterLaVersionPapierBouton.click();
        log.info("Click on le button Consulter la version papier");
    }

    @Step("Chapter selection")
    public void chapterSelection(String chapterName){
        Locator chapterLocator = this.page.locator( "text = " +chapterName).nth(0);
        assertIfLocatorIsVisible(chapterLocator);
        chapterLocator.click();
        log.info("Chapter selection");
    }

    @Step("title validation")
    public void titleValidation(String titleOfPage){
        assertIfLocatorIsVisible(titlePage);
        assertThatElementContainsText(titlePage,titleOfPage);
        log.info("title validation");
    }

    @Step("Chapter selection")
    public void subTitleValidation(String subTitle){
        Locator chapterLocator = this.page.locator( "text = " +subTitle);
        assertIfLocatorIsVisible(chapterLocator);
        chapterLocator.click();
        log.info("Subtitle validation");
    }

    @Step("Introduction text validation")
    public void introductionTextValidation(String introductionText){
        assertIfLocatorIsVisible(firstParagraph);
        assertThatElementContainsText(firstParagraph,introductionText);
        log.info("Introduction text Validation");
    }

    @Step("Je contribue button is visible")
    public void jeContribueButtonIsVisible(){
        assertIfLocatorIsVisible(jeContribueBoutton);
        log.info("Validasion Je contribue button is visible");
    }
}