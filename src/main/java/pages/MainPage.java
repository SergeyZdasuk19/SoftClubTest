package pages;

import manager.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {
    private PropertyManager propertyManager;

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public MainPage(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, 30);
        propertyManager = new PropertyManager();
    }

    public void logOut() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("ImgAccount")));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(propertyManager.getLocator("ImgAccount")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("ButtonExit")));
        driver.findElement(propertyManager.getLocator("ButtonExit")).click();
    }

    public void writeMessage(String whom, String subject, String text) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("WriteMessage")));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(propertyManager.getLocator("WriteMessage")).click();
        driver.findElement(propertyManager.getLocator("ToWhom")).sendKeys(whom);
        driver.findElement(propertyManager.getLocator("Subject")).sendKeys(subject);
        driver.findElement(propertyManager.getLocator("Text")).sendKeys(text);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(propertyManager.getLocator("ButtonSend")));
        driver.findElement(propertyManager.getLocator("ButtonSend")).click();
    }

    public String getTitleMainPage() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Img")));
        return driver.getTitle();
    }

    public boolean isMessageContainsUserEmail(String username) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(propertyManager.getLocator("Message")));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(propertyManager.getLocator("Message")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("MessageEmail")));
        return driver.findElement(propertyManager.getLocator("MessageEmail")).getText().contains(username);
    }
}
