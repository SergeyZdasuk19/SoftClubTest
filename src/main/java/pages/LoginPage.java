package pages;

import manager.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage {
    private PropertyManager propertyManager;

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, 20);
        propertyManager = new PropertyManager();
    }

    public void inputLogin(String username) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Username_field")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(propertyManager.getLocator("Username_field")).clear();
        driver.findElement(propertyManager.getLocator("Username_field")).sendKeys(username);
        driver.findElement(propertyManager.getLocator("UsernameButtonNext")).click();
    }

    public void inputPassword(String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Password_field")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(propertyManager.getLocator("Password_field")).clear();
        driver.findElement(propertyManager.getLocator("Password_field")).sendKeys(password);
        driver.findElement(propertyManager.getLocator("PasswordButtonNext")).click();
    }

    public String getTitleLogInPage() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("PasswordButtonNext")));
        return driver.getTitle();
    }
}
