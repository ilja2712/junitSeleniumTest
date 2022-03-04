package tests.positive;

import org.junit.jupiter.api.Test;
import base.BaseTest;

import static constants.Constant.LoginTestData.*;
import static constants.Constant.Urls.LOGIN_URL;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void checkLoginPage() {
        basePage.goToUrl(LOGIN_URL);
        basePage.isAuthWidgetPresent();
    }

    @Test
    public void checkAuthToHomePage() {
        basePage.goToUrl(LOGIN_URL);
        loginPage
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .authSubmit();
        homePage
                .checkNameProfile(AVATAR_NAME);
    }

    @Test
    public void showPageChangePassword() {
        basePage.goToUrl(LOGIN_URL);
        loginPage.changePassword();
        changePasswordPage.checkPasswordRecovery();
    }
}
