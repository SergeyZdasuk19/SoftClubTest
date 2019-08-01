package manager;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static String userDirectory = "user.dir";
    private static String propertyUserFilePath = System.getProperty(userDirectory) +
            "\\src\\test\\resources\\datafile.properties";
    private static String propertyLocatorFilePath = System.getProperty(userDirectory) +
            "\\src\\test\\resources\\locator.properties";
    private static String propertyMessageFilePath = System.getProperty(userDirectory) +
            "\\src\\test\\resources\\message.properties";
    private static Properties userProperties;
    private static Properties locatorProperties;
    private static Properties messageProperties;

    static {
        userProperties = new Properties();
        locatorProperties = new Properties();
        messageProperties = new Properties();
    }

    public static Properties getUserProperties() {
        return userProperties;
    }

    public static Properties getMessageProperties() {
        return messageProperties;
    }

    public void loadLocatorData() {
        try {
            locatorProperties.load(new FileInputStream(propertyLocatorFilePath));
        } catch (IOException e) {
            System.out.println("Configuration locator properties file cannot be found");
        }
    }

    public void loadUserData() {
        try {
            userProperties.load(new FileInputStream(propertyUserFilePath));
        } catch (IOException e) {
            System.out.println("Configuration user properties file cannot be found");
        }
    }

    public void loadMessageData() {
        try {
            messageProperties.load(new FileInputStream(propertyMessageFilePath));
        } catch (IOException e) {
            System.out.println("Configuration message properties file cannot be found");
        }
    }

    public By getLocator(String elementName) {
        String locator = locatorProperties.getProperty(elementName);
        return By.cssSelector(locator);
    }

}
