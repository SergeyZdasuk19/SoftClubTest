package Pages;

import Manager.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage {
    private final String baseUrl = "https://gmail.com";
    private Properties userProperties;
    private Properties locatorProperties;
    private PropertyManager propertyManager;

    @Override
    public void openPage() {
        driver.get(baseUrl);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        propertyManager = new PropertyManager();
        userProperties = PropertyManager.getUserProperties();
        locatorProperties = PropertyManager.getLocatorProperties();
    }

    public void inputLogin(String username) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        driver.findElement(propertyManager.getLocator("Username_field")).clear();
        driver.findElement(propertyManager.getLocator("Username_field")).sendKeys(username);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("UsernameButtonNext")));
        driver.findElement(propertyManager.getLocator("UsernameButtonNext")).click();
    }

    public void inputPassword(String password) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Password_field")));
        driver.findElement(propertyManager.getLocator("Password_field")).clear();
        driver.findElement(propertyManager.getLocator("Password_field")).sendKeys(password);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("PasswordButtonNext")));
        driver.findElement(propertyManager.getLocator("PasswordButtonNext")).click();
    }

    public String getTitleLogInPage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("PasswordButtonNext")));
        return driver.getTitle();
    }
}
