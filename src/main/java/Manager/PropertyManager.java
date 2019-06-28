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
    private static String propertyMessageFilePath = System.getProperty("user.dir") +
            "\\src\\test\\resources\\message.properties";
    private static Properties userProperties;
    private static Properties locatorProperties;
    private static Properties messageProperties;

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

    public static Properties getMessageProperties() {
        if (null == messageProperties) {
            messageProperties = new Properties();
        }
        return messageProperties;
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

    public void loadMessageData() {
        try {
            messageProperties.load(new FileInputStream(propertyMessageFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public By getLocator(String ElementName) {
        String locator = locatorProperties.getProperty(ElementName);
        return By.xpath(locator);
    }

}
