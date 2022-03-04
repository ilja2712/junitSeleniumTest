package common;

public class Config {

    /**
     * Specify the browser and platform for test:
     *
     * CHROME_MAC
     * CHROME_WIN
     * MOZILLA_MAC
     *
     */
    public static final String BROWSER_AND_PLATFORM = "CHROME_MAC";
    /**
     * Clear cookies and localStorage after each iteration
     */
    public static final Boolean CLEAR_COOKIES = true;
    /**
     * Close browser after each all scenario/tests
     */
    public static final Boolean HOLD_BROWSER_OPEN = false;
}
