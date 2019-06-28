package Pages;

import Manager.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {
    private final String baseUrl = "https://gmail.com";
    private Properties userProperties;
    private Properties locatorProperties;
    private Properties messageProperties;
    private PropertyManager propertyManager;

    @Override
    public void openPage() {
        driver.get(baseUrl);
    }

    public MainPage(WebDriver driver) {
        super(driver);
        propertyManager = new PropertyManager();
        userProperties = PropertyManager.getUserProperties();
        locatorProperties = PropertyManager.getLocatorProperties();
        messageProperties = PropertyManager.getMessageProperties();
    }

    public void logOut(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("ImgAccount")));
        driver.findElement(propertyManager.getLocator("ImgAccount")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("ButtonExit")));
        driver.findElement(propertyManager.getLocator("ButtonExit")).click();
    }

    public void writeMessage(String whom,String subject,String text){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("WriteMessage")));
        driver.findElement(propertyManager.getLocator("WriteMessage")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("ToWhom")));
        driver.findElement(propertyManager.getLocator("ToWhom")).click();
        driver.findElement(propertyManager.getLocator("ToWhom")).sendKeys(whom);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Subject")));
        driver.findElement(propertyManager.getLocator("Subject")).sendKeys(subject);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Text")));
        driver.findElement(propertyManager.getLocator("Text")).click();
        driver.findElement(propertyManager.getLocator("Text")).sendKeys(text    );

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("ButtonSend")));
        driver.findElement(propertyManager.getLocator("ButtonSend")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Message")));
        driver.findElement(propertyManager.getLocator("Message")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Content")));

    }

    public String getTitleMainPage(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Img")));
        return driver.getTitle();
    }

    public boolean isMessageContainsUserEmail(String username){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(propertyManager.getLocator("Content")));
        return true;
    }
}
