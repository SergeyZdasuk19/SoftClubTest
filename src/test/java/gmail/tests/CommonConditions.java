package gmail.tests;

import gmail.business.BusinessModel;
import gmail.driver.DriverSingleton;
import gmail.services.CreatorBusinessModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;
    protected BusinessModel model;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        driver = DriverSingleton.getDriver();
        model = CreatorBusinessModel.createBusinessModel(driver);
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
