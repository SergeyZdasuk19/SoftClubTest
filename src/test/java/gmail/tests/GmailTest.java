package gmail.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class GmailTest extends CommonConditions {

    @Test
    public void oneCanLogIn() {
        loginBusinessObject.openPage();
        loginBusinessObject.inputUserlogin(user.getUserName());
        loginBusinessObject.inputUserPassword(user.getPassword());
        Assert.assertTrue(mainBusinessObject.getTitle().contains(user.getUserName()));
    }

    @Test
    public void oneCanLogOut() {
        mainBusinessObject.logOut();
        loginBusinessObject.inputUserPassword(user.getPassword());
        Assert.assertFalse(loginBusinessObject.getTitle().contains(user.getUserName()));
    }

    @Test
    public void oneCanWriteMessage() {
        mainBusinessObject.writeMessage(user.getUserName(), message.getSubjectMessage(), message.getTextMessage());
        Assert.assertTrue(mainBusinessObject.isMessageContainsUserEmail(user.getUserName()));
    }
}