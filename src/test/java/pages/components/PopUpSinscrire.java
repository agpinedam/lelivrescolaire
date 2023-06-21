package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class PopUpSinscrire extends BasePage {

    private final Locator selectRole;
    private final Locator email;
    private final Locator continueButton;
    private final Locator errorMessage;

    private final Logger log = LoggerFactory.getLogger(PopUpSinscrire.class);

    public PopUpSinscrire(Page page) {
        super(page);
        selectRole = page.locator(".MuiSelect-root");
        email = page.locator(".MuiInputBase-input");
        continueButton = page.locator(".MuiButtonBase-root");
        errorMessage = page.locator(".MuiFormHelperText-root");
    }

    @Step("Select Role")
    public void selectARole(String role) {
        assertIfLocatorIsVisible(selectRole);
        selectRole.selectOption(role);
        log.info("Select role");
    }

    @Step("Select more than 15 ans")
    public void selectMoreThan15Years() {
        assertIfLocatorIsVisible(selectRole.nth(1));
        selectRole.nth(1).selectOption("false");
        log.info("Select more that 15 years");
    }

    @Step("Type Email")
    public void typeWrongEmail() {
        int maxNumber = email.count() - 1;
        assertIfLocatorIsVisible(email.nth(maxNumber));
        email.nth(maxNumber).type("a@gmail.com");
        log.info("Type email");
    }

    @Step("Click on Continue Button")
    public void clickOnContinueButton() {
        assertIfLocatorIsVisible(continueButton.nth(4));
        continueButton.nth(4).click();
        log.info("Click on continue button");
    }

    @Step("Assert Error Message")
    public void assertErrorMessage() {
        assertThatElementContainsText(errorMessage,
                "Cet email n'est pas valide ou est déjà utilisé. Si vous possédez un compte, connectez-vous ou réinitialisez votre mot de passe.");
        log.info("Valid assert");
    }

    @Step("Assert Error Message. This step going to fail")
    public void assertErrorMessageFail() {
        assertThatElementContainsText(errorMessage,
                "Email n'est pas valide");
        log.info("Invalid assert");
    }
}