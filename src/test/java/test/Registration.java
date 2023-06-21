package test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


public class Registration extends BaseTest {

    @Test
    @Feature("Registration")
    @Description("As user I want to create an student account with an invalid mail")
    public void createTeacherAccount() {
        manuelGeographie.menuComponent.clickOnCreateNewAccount();
        popUpSinscrire.selectARole("student");
        popUpSinscrire.selectMoreThan15Years();
        popUpSinscrire.typeWrongEmail();
        popUpSinscrire.clickOnContinueButton();
        popUpSinscrire.assertErrorMessage();
    }


    @Test
    @Feature("Registration")
    @Description("As user I want to create a teacher account with an invalid mail")
    public void createStudentAccount() {
        manuelGeographie.menuComponent.clickOnCreateNewAccount();
        popUpSinscrire.selectARole("teacher");
        popUpSinscrire.typeWrongEmail();
        popUpSinscrire.clickOnContinueButton();
        popUpSinscrire.assertErrorMessage();
    }

    @Test (priority = 3)
    @Feature("Registration")
    @Description("As user I want to create a teacher account with an invalid mail. This test will fail always")
    public void createError() {
        manuelGeographie.menuComponent.clickOnCreateNewAccount();
        popUpSinscrire.selectARole("teacher");
        popUpSinscrire.typeWrongEmail();
        popUpSinscrire.clickOnContinueButton();
        popUpSinscrire.assertErrorMessageFail();
    }


}
