package gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private String userNameField;
    private String userNameButtonNext;
    private String userPasswordField;
    private String userPasswordButtonNext;

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public LoginPage(WebDriver driver, String userNameField, String userNameButtonNext, String userPasswordField,
                     String userPasswordButtonNext) {
        super(driver);
        this.userNameField = userNameField;
        this.userNameButtonNext = userNameButtonNext;
        this.userPasswordField = userPasswordField;
        this.userPasswordButtonNext = userPasswordButtonNext;
    }

    public void inputLogin(String username) {
        getElementTotallyLocated(By.cssSelector(userNameField)).sendKeys(username);
        runPerformedElement(By.cssSelector(userNameButtonNext));
    }

    public void inputPassword(String password) {
        getElementTotallyLocated(By.cssSelector(userPasswordField)).sendKeys(password);
        runPerformedElement(By.cssSelector(userPasswordButtonNext));
    }

    public String getTitleLogInPage() {
        getElementTotallyLocated(By.cssSelector(userPasswordField));
        return driver.getTitle();
    }
}
