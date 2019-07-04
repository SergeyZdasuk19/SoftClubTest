package Steps;

import Driver.DriverSingleton;
import Manager.PropertyManager;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.WebDriver;

public class Steps {
    private WebDriver driver;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public void logInGmail(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.inputLogin(username);
        loginPage.inputPassword(password);
    }

    public void logOutGmail() {
        MainPage mainPage = new MainPage(driver);
        mainPage.logOut();
    }

    public void loadData() {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadUserData();
        propertyManager.loadLocatorData();
        propertyManager.loadMessageData();
    }

    public void writeMessage(String whom, String subject, String text) {
        MainPage mainPage = new MainPage(driver);
        mainPage.writeMessage(whom, subject, text);
    }

    public void inputPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword(password);
    }

    public boolean isMessageContainsUserEmail(String username){
        MainPage mainPage = new MainPage(driver);
        return mainPage.isMessageContainsUserEmail(username);
    }
    public String getTitleMainPage() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getTitleMainPage();
    }

    public String getTitleLogInPage() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getTitleLogInPage();
    }
}
