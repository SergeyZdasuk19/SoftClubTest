package gmail.businessObjects;

import gmail.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBusinessObject {

    private LoginPage loginPage;

    public LoginBusinessObject(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void openPage() {
        loginPage.openPage();
    }

    public void inputUserlogin(String login) {
        loginPage.inputLogin(login);
    }

    public void inputUserPassword(String password) {
        loginPage.inputPassword(password);
    }

    public String getTitle() {
        return loginPage.getTitleLogInPage();
    }
}
