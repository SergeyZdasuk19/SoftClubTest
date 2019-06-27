package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String webDriver = "webdriver.chrome.driver";
    private static final String webDriverExePath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

    private DriverSingleton() {};


    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(webDriver, webDriverExePath);
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