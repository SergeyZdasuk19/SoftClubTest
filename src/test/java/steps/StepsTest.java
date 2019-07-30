package steps;

import business.BusinessObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class StepsTest {
    private Steps steps;
    private BusinessObject businessObject;

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        businessObject = new BusinessObject();
        steps.loadData();
        steps.openBrowser();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeBrowser();
    }

    @Test
    public void oneCanLogIn() {
        steps.logInGmail(businessObject.getUser().getUserName(), businessObject.getUser().getPassword());
        Assert.assertTrue(steps.getTitleMainPage().contains(businessObject.getUser().getUserName()));
    }

    @Test
    public void oneCanLogOut() {
        steps.logOutGmail();
        Assert.assertFalse(steps.getTitleLogInPage().contains(businessObject.getUser().getUserName()));
    }

    @Test
    public void oneCanWriteMessage() {
        steps.inputPassword(businessObject.getUser().getPassword());
        steps.writeMessage(businessObject.getUser().getUserName(), businessObject.getMessage().getSubjectMessage(), businessObject.getMessage().getTextMessage());
        Assert.assertTrue(steps.isMessageContainsUserEmail("Сергей"));
    }
}