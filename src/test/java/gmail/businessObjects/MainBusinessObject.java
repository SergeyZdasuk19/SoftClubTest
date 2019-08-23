package gmail.businessObjects;

import gmail.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainBusinessObject {

    private MainPage mainPage;

    public MainBusinessObject(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    public void logOut() {
        mainPage.logOut();
    }

    public void writeMessage(String whom, String subject, String text) {
        mainPage.writeMessage(whom, subject, text);
    }

    public String getTitle() {
        return mainPage.getTitleMainPage();
    }

    public boolean isMessageContainsUserEmail(String username) {
        return mainPage.isMessageContainsUserEmail(username);
    }

}
