package gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final String BASE_URL = "https://gmail.com";
    protected final int WAIT_TIMEOUT_SECONDS = 20;
    protected final int WAIT_TIMEOUT_MILLI_SECONDS = 8000;

    public abstract void openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void runPerformedElement(By by) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS, WAIT_TIMEOUT_MILLI_SECONDS).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public WebElement getElementTotallyLocated(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
