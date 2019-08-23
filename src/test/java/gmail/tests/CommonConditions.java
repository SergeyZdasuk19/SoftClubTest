package gmail.tests;

import gmail.businessObjects.LoginBusinessObject;
import gmail.businessObjects.MainBusinessObject;
import gmail.driver.DriverSingleton;
import gmail.entity.Message;
import gmail.entity.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonConditions {
    protected WebDriver driver;
    protected LoginBusinessObject loginBusinessObject;
    protected MainBusinessObject mainBusinessObject;
    protected User user;
    protected Message message;

    @BeforeClass(description = "Init browser")
    public void setUp() {
        driver = DriverSingleton.getDriver();
        user = new User("zdasuksergey@gmail.com","Sergey123456");
        message = new Message("Test", "Test message");
        loginBusinessObject = new LoginBusinessObject(driver);
        mainBusinessObject = new MainBusinessObject(driver);
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
