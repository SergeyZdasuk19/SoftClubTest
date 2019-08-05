package gmail.services;

import java.util.ResourceBundle;

public class DataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("datafile");

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
