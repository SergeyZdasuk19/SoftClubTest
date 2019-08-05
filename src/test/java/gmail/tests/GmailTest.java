package gmail.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class GmailTest extends CommonConditions {

    @Test
    public void oneCanLogIn() {
        model.getLoginPage().openPage();
        model.getLoginPage().inputLogin(model.getUser().getUserName());
        model.getLoginPage().inputPassword(model.getUser().getPassword());
        Assert.assertTrue(model.getMainPage().getTitleMainPage().contains(model.getUser().getUserName()));
    }

    @Test
    public void oneCanLogOut() {
        model.getLoginPage().openPage();
        model.getLoginPage().inputLogin(model.getUser().getUserName());
        model.getLoginPage().inputPassword(model.getUser().getPassword());
        model.getMainPage().logOut();
        Assert.assertFalse(model.getLoginPage().getTitleLogInPage().contains(model.getUser().getUserName()));
    }

    @Test
    public void oneCanWriteMessage() {
        model.getLoginPage().openPage();
        model.getLoginPage().inputLogin(model.getUser().getUserName());
        model.getLoginPage().inputPassword(model.getUser().getPassword());
        model.getMainPage().writeMessage(model.getUser().getUserName(), model.getMessage().getSubjectMessage(), model.getMessage().getTextMessage());
        Assert.assertTrue(model.getMainPage().isMessageContainsUserEmail(model.getUser().getUserName()));
    }
}