package gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {
    private String imgAccount;
    private String buttongSingOut;
    private String img;
    private String writeMessage;
    private String fieldToWhom;
    private String fieldSubject;
    private String fieldText;
    private String buttonSendMessage;
    private String emailInMassage;
    private String listOfMessages;

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public MainPage(WebDriver driver, String imgAccount, String buttongSingOut, String img, String writeMessage,
                    String fieldToWhom, String fieldSubject, String fieldText, String buttonSendMessage,
                    String emailInMassage, String listOfMessages) {
        super(driver);
        this.imgAccount = imgAccount;
        this.buttongSingOut = buttongSingOut;
        this.img = img;
        this.writeMessage = writeMessage;
        this.fieldToWhom = fieldToWhom;
        this.fieldSubject = fieldSubject;
        this.fieldText = fieldText;
        this.buttonSendMessage = buttonSendMessage;
        this.emailInMassage = emailInMassage;
        this.listOfMessages = listOfMessages;
    }

    public void logOut() {
        runPerformedElement(By.cssSelector(imgAccount));
        runPerformedElement(By.cssSelector(buttongSingOut));
    }

    public void writeMessage(String whom, String subject, String text) {
        runPerformedElement(By.cssSelector(writeMessage));
        getElementTotallyLocated(By.cssSelector(fieldToWhom)).sendKeys(whom);
        getElementTotallyLocated(By.cssSelector(fieldSubject)).sendKeys(subject);
        getElementTotallyLocated(By.cssSelector(fieldText)).sendKeys(text);
        runPerformedElement(By.cssSelector(buttonSendMessage));
    }

    public String getTitleMainPage() {
        getElementTotallyLocated(By.cssSelector(img));
        return driver.getTitle();
    }

    public boolean isMessageContainsUserEmail(String username) {
        runPerformedElement(By.cssSelector(listOfMessages));
        return getElementTotallyLocated(By.cssSelector(emailInMassage)).getText().contains(username);
    }
}
