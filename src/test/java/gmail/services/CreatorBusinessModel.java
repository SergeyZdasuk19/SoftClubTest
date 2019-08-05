package gmail.services;

import gmail.business.BusinessModel;
import gmail.entity.Message;
import gmail.entity.User;
import gmail.pages.LoginPage;
import gmail.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class CreatorBusinessModel {
    private static final String USER_USER_NAME = "user.username";
    private static final String USER_USER_PASSWORD = "user.password";
    private static final String MESSAGE_SUBJECT_MESSAGE = "message.SubjectMessage";
    private static final String MESSAGE_TEXT_MESSAGE = "message.TextMessage";
    private static final String LOCATOR_USER_NAME_FIELD = "locator.Username_field";
    private static final String LOCATOR_USER_NAME_BUTTON_NEXT = "locator.UsernameButtonNext";
    private static final String LOCATOR_PASSWORD_FIELD = "locator.Password_field";
    private static final String LOCATOR_PASSWORD_BUTTON_NEXT = "locator.PasswordButtonNext";
    private static final String LOCATOR_IMG_ACCOUNT = "locator.ImgAccount";
    private static final String LOCATOR_BUTTON_SING_OUT = "locator.ButtonSingOut";
    private static final String LOCATOR_IMG = "locator.Img";
    private static final String LOCATOR_WRITE_MESSAGE = "locator.WriteMessage";
    private static final String LOCATOR_FIELD_TO_WHOM = "locator.FieldToWhom";
    private static final String LOCATOR_FIELD_SUBJECT = "locator.FieldSubject";
    private static final String LOCATOR_FIELD_TEXT = "locator.FieldText";
    private static final String LOCATOR_BUTTON_SEND_MESSAGE = "locator.ButtonSendMessage";
    private static final String LOCATOR_EMAIL_IN_MESSAGE = "locator.EmailInMessage";
    private static final String LOCATOR_LIST_OF_MESSAGES = "locator.ListOfMessages";

    public static BusinessModel createBusinessModel(WebDriver driver) {
        return new BusinessModel(new User(DataReader.getTestData(USER_USER_NAME), DataReader.getTestData(USER_USER_PASSWORD)),
                new Message(DataReader.getTestData(MESSAGE_SUBJECT_MESSAGE), DataReader.getTestData(MESSAGE_TEXT_MESSAGE)),
                new LoginPage(driver, DataReader.getTestData(LOCATOR_USER_NAME_FIELD), DataReader.getTestData(LOCATOR_USER_NAME_BUTTON_NEXT), DataReader.getTestData(LOCATOR_PASSWORD_FIELD), DataReader.getTestData(LOCATOR_PASSWORD_BUTTON_NEXT)),
                new MainPage(driver, DataReader.getTestData(LOCATOR_IMG_ACCOUNT), DataReader.getTestData(LOCATOR_BUTTON_SING_OUT), DataReader.getTestData(LOCATOR_IMG),
                        DataReader.getTestData(LOCATOR_WRITE_MESSAGE), DataReader.getTestData(LOCATOR_FIELD_TO_WHOM), DataReader.getTestData(LOCATOR_FIELD_SUBJECT),
                        DataReader.getTestData(LOCATOR_FIELD_TEXT), DataReader.getTestData(LOCATOR_BUTTON_SEND_MESSAGE), DataReader.getTestData(LOCATOR_EMAIL_IN_MESSAGE),
                        DataReader.getTestData(LOCATOR_LIST_OF_MESSAGES)));
    }
}
