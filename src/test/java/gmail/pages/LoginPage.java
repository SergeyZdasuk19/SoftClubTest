package gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private By userNameField;
    private By userNameButtonNext;
    private By userPasswordField;
    private By userPasswordButtonNext;

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputLogin(String username) {
        userNameField = By.cssSelector("input[type='email']");
        userNameButtonNext = By.cssSelector("#identifierNext");
        getElementTotallyLocated(userNameField).sendKeys(username);
        runPerformedElement(userNameButtonNext);
    }

    public void inputPassword(String password) {
        userPasswordField = By.cssSelector("input[type='password']");
        userPasswordButtonNext = By.cssSelector("#passwordNext");
        getElementTotallyLocated(userPasswordField).sendKeys(password);
        runPerformedElement(userPasswordButtonNext);
    }

    public String getTitleLogInPage() {
        userPasswordField = By.cssSelector("input[type='password']");
        getElementTotallyLocated(userPasswordField);
        return driver.getTitle();
    }
}
