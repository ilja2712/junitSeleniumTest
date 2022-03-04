package pages.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class ChangePasswordPage extends BasePage {

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By avatarName = By.xpath("//div[contains(text(), 'Восстановление пароля')]");

    public ChangePasswordPage checkPasswordRecovery() {
        waitElementIsVisible(driver.findElement(avatarName));
        return this;
    }
}
