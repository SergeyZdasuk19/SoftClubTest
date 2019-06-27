package Manager;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static String propertyUserFilePath = System.getProperty("user.dir") +
            "\\src\\test\\resources\\datafile.properties";
    private static String propertyLocatorFilePath = System.getProperty("user.dir") +
            "\\src\\test\\resources\\locator.properties";
    private static Properties userProperties;
    private static Properties locatorProperties;

    public static Properties getUserProperties() {
        if (null == userProperties) {
            userProperties = new Properties();
        }
        return userProperties;
    }

    public static Properties getLocatorProperties() {
        if (null == locatorProperties) {
            locatorProperties = new Properties();
        }
        return locatorProperties;
    }

    public void loadLocatorData() {
        try {
            locatorProperties.load(new FileInputStream(propertyLocatorFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public void loadUserData() {
        try {
            userProperties.load(new FileInputStream(propertyUserFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public By getLocator(String ElementName) {
        String locator = locatorProperties.getProperty(ElementName);
        return By.xpath(locator);
    }

}
