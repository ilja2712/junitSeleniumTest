package pages.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By avatarName = By.xpath("//div[@class='avatar-full-name']");

    public HomePage checkNameProfile(String name) {
        waitElementIsVisible(driver.findElement(avatarName));
        WebElement element = driver.findElement(avatarName);
        Assertions.assertEquals(name, element.getText());
        return this;
    }

    public HomePage backPage() {
        driver.navigate().back();
        return this;
    }
}
