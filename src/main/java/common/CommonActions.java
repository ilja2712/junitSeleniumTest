package common;

import constants.Constant;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonActions {

    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch(Config.BROWSER_AND_PLATFORM) {
            case "CHROME_MAC":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "CHROME_WIN":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "MOZILLA_MAC":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("INCORRECT BROWSER NAME " + Config.BROWSER_AND_PLATFORM);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constant.TimeoutVariables.IMPLICIT_WAIT, TimeUnit.SECONDS);

        return driver;
    }
}