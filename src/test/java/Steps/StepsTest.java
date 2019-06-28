package Steps;

import Entity.Message;
import Entity.User;
import Manager.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;


public class StepsTest {
    private Steps steps;
    private User user;
    private Message message;
    private Properties userProperties;
    private Properties messageProperties;
    private Properties locatorProperties;
    private PropertyManager propertyManager;

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        user = new User();
        message = new Message();
        locatorProperties = PropertyManager.getLocatorProperties();
        userProperties = PropertyManager.getUserProperties();
        messageProperties = PropertyManager.getMessageProperties();
        steps.loadData();
        user.setUserName(userProperties.getProperty("username"));
        user.setPassword(userProperties.getProperty("password"));
        message.setSubjectMessage(messageProperties.getProperty("SubjectMessage"));
        message.setTextMessage(messageProperties.getProperty("TextMessage"));
        steps.openBrowser();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeBrowser();
    }

    @Test
    public void oneCanLogIn() {
        steps.logInGmail(user.getUserName(), user.getPassword());
        Assert.assertTrue(steps.getTitleMainPage().contains(user.getUserName()));
    }

    @Test
    public void oneCanLogOut() {
        steps.logOutGmail();
        Assert.assertFalse(steps.getTitleLogInPage().contains(user.getUserName()));
    }

    @Test
    public void oneCanWriteMessage() {
        steps.inputPassword(user.getPassword());
        steps.writeMessage(user.getUserName(), message.getSubjectMessage(), message.getTextMessage());
        Assert.assertTrue(steps.isMessageContainsUserEmail("Сергей"));
    }
}