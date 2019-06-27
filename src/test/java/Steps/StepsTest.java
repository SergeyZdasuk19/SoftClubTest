package Steps;

import Entity.User;
import Manager.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;


public class StepsTest {
    private Steps steps;
    private User user;
    private Properties userProperties;
    private Properties locatorProperties;
    private PropertyManager propertyManager;

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        user = new User();
        locatorProperties = PropertyManager.getLocatorProperties();
        userProperties = PropertyManager.getUserProperties();
        steps.loadData();
        user.setUserName(userProperties.getProperty("username"));
        user.setPassword(userProperties.getProperty("password"));
        steps.openBrowser();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeBrowser();
    }

    @Test
    public void oneCanLogIn() {
        steps.loginGmail(user.getUserName(),user.getPassword());
        Assert.assertEquals(steps.getLogin(),user.getUserName());
        Assert.assertEquals(steps.getPassword(),user.getUserName());
    }
}