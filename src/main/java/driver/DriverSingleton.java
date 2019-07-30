package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String WEB_DRIVER = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(WEB_DRIVER, WEB_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}