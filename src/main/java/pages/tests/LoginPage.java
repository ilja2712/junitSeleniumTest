package pages.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By inputLogin = By.xpath("//input[@name='user']");
    private final By inputPassword = By.xpath("//input[@name='password']");
    private final By buttonSubmit = By.xpath("//button[@type='submit']");
    private final By buttonShowPassword = By.xpath("//button[@id='show_password']");
    private final By buttonForgotPassword = By.xpath("//a[@class='mira-default-login-page-link']");

    public LoginPage enterLogin(String login) {
        driver.findElement(inputLogin).sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public LoginPage authSubmit() {
        driver.findElement(buttonSubmit).click();
        return this;
    }

    public LoginPage checkAlert(String text) {
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT);
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals(text, alert.getText());
        alert.dismiss();
        return this;
    }

    public LoginPage checkTypePassword() {
        WebElement password = driver.findElement(inputPassword);
        Assertions.assertEquals("password", password.getAttribute("type"));
        return this;
    }

    public LoginPage showPassword(String pass) {
        driver.findElement(buttonShowPassword).click();
        WebElement password = driver.findElement(inputPassword);
        Assertions.assertEquals(pass, password.getAttribute("value"));
        return this;
    }

    public LoginPage changePassword() {
        driver.findElement(buttonForgotPassword).click();
        return this;
    }


}
