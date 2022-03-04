package tests.negative;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static constants.Constant.LoginTestData.*;
import static constants.Constant.Urls.LOGIN_URL;
import static constants.Constant.WarnMessage.TEXT_ALERT;
import static constants.Constant.WarnMessage.TEXT_ALERT_UPPERCASE;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void checkLoginPage() {
        basePage.goToUrl(LOGIN_URL);
        basePage.isAuthWidgetPresent();
    }

    @Test
    public void checkEmptyField() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin("")
                .enterPassword("")
                .authSubmit()
                .checkAlert(TEXT_ALERT);
    }

    @Test
    public void checkTestData() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin("Test")
                .enterPassword("Test")
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkOnlyLogin() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN)
                .enterPassword("")
                .authSubmit()
                .checkAlert(TEXT_ALERT);
    }

    @Test
    public void checkOnlyPassword() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin("")
                .enterPassword(PASSWORD)
                .authSubmit()
                .checkAlert(TEXT_ALERT);
    }

    @Test
    public void checkValidLoginWithSpaces() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN + " ")
                .enterPassword(PASSWORD)
                .authSubmit()
                .checkAlert(TEXT_ALERT);
    }

    @Test
    public void checkValidPasswordWithSpaces() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD + " ")
                .authSubmit()
                .checkAlert(TEXT_ALERT);
    }

    @Test
    public void checkLoginUppercase() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(NOT_VALID_LOGIN)
                .enterPassword(NOT_VALID_PASSWORD)
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkUppercaseInLogin() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(NOT_VALID_LOGIN)
                .enterPassword(PASSWORD)
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkUppercaseInPassword() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN)
                .enterPassword(NOT_VALID_PASSWORD)
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkSpecialSymbols() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin("fominaelena!?;:")
                .enterPassword("1!P73BP4Z?")
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkSpecialSymbolsInLogin() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin("fominaelena!?;:")
                .enterPassword(PASSWORD)
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkSpecialSymbolsInPassword() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN)
                .enterPassword("1!P73BP4Z?")
                .authSubmit()
                .checkAlert(TEXT_ALERT_UPPERCASE);
    }

    @Test
    public void checkSecurityPassword() {
        basePage.goToUrl(LOGIN_URL);
        loginPage.checkTypePassword();
    }

    @Test
    public void showPassword() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterPassword(PASSWORD)
                .showPassword(PASSWORD);
    }

    @Test
    public void checkAuthUserAfterBackPage() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .authSubmit();
        homePage
                .checkNameProfile(AVATAR_NAME)
                .backPage();
        homePage.checkNameProfile(AVATAR_NAME);
    }
}
