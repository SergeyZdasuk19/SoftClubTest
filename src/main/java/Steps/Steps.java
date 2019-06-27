package Steps;

import Driver.DriverSingleton;
import Manager.PropertyManager;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Steps {
    private WebDriver driver;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public void loginGmail(String username,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username,password);
    }

    public void loadData() {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadUserData();
        propertyManager.loadLocatorData();
    }

    public String getLogin() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getLogin();
    }

    public String getPassword() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getPassword();
    }
}
