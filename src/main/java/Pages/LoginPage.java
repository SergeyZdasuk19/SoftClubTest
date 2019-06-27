package Pages;

import Manager.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

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

    public void login(String username, String password) {
        driver.findElement(propertyManager.getLocator("Username_field")).clear();
        driver.findElement(propertyManager.getLocator("Username_field")).sendKeys(username);
        driver.findElement(propertyManager.getLocator("ButtonNext")).click();
        driver.findElement(propertyManager.getLocator("Password_field")).clear();
        driver.findElement(propertyManager.getLocator("Password_field")).sendKeys(password);
        driver.findElement(propertyManager.getLocator("ButtonNext")).click();
    }

    public String getLogin() {
        return driver.findElement(propertyManager.getLocator("Username_field")).getAttribute("value");
    }

    public String getPassword() {
        return driver.findElement(propertyManager.getLocator("Password_field")).getAttribute("value");
    }
}
