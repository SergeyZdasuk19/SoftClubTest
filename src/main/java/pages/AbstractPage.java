package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected final String BASE_URL = "https://gmail.com";
    public abstract void openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
