package gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private By imgAccount;
    private By buttongSingOut;
    private By img;
    private By writeMessage;
    private By fieldToWhom;
    private By fieldSubject;
    private By fieldText;
    private By buttonSendMessage;
    private By emailInMassage;
    private By listOfMessages;

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        imgAccount = By.cssSelector("a[aria-label*='Google:']");
        buttongSingOut = By.cssSelector("a[href*='Logout']");
        runPerformedElement(imgAccount);
        runPerformedElement(buttongSingOut);
    }

    public void writeMessage(String whom, String subject, String text) {
        writeMessage = By.cssSelector("div[style*='user'][role='button']");
        fieldToWhom = By.cssSelector("textarea[name='to']");
        fieldSubject = By.cssSelector("input[name='subjectbox']");
        fieldText = By.cssSelector("div[role='textbox']");
        buttonSendMessage = By.cssSelector("div[data-tooltip][tabindex='1']");
        runPerformedElement(writeMessage);
        getElementTotallyLocated(fieldToWhom).sendKeys(whom);
        getElementTotallyLocated(fieldSubject).sendKeys(subject);
        getElementTotallyLocated(fieldText).sendKeys(text);
        runPerformedElement(buttonSendMessage);
    }

    public String getTitleMainPage() {
        img = By.cssSelector("a[href='#inbox'] img");
        getElementTotallyLocated(img);
        return driver.getTitle();
    }

    public boolean isMessageContainsUserEmail(String username) {
        listOfMessages = By.cssSelector("table[id*='2k'] tbody :nth-child(1)");
        emailInMassage = By.cssSelector("span[role='gridcell'] :nth-child(2)");
        runPerformedElement(listOfMessages);
        return getElementTotallyLocated(emailInMassage).getText().contains(username);
    }
}
