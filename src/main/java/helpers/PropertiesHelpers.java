package main.java.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelpers {
        private static Properties properties;
        private static String linkFile;
        private static FileInputStream file;
        private static FileOutputStream out;
        private static String relPropertiesFilePathDefault = "src/test/resources/config/config.properties";

        public static Properties loadAllFiles() {
            LinkedList<String> files = new LinkedList<>();
            files.add("src/test/resources/config.properties");

            try {
                properties = new Properties();

                for (String f : files) {
                    Properties tempProp = new Properties();
                    linkFile = getCurrentDir() + f;
                    file = new FileInputStream(linkFile);
                    tempProp.load(file);
                    properties.putAll(tempProp);
                }
                file.close();
                return properties;
            } catch (IOException e) {
                return new Properties();
            }
        }
    public static String getValue(String key) {
        String keyValue = null;
        try {
            if (file == null && properties == null) {
                properties = new Properties();
                linkFile = getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Get value from file
            keyValue = properties.getProperty(key);
            return convertCharset_ISO_8859_1_To_UTF8(keyValue);
            //return keyValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return keyValue;
        }
    }
    private static String convertCharset_ISO_8859_1_To_UTF8(String text) {
        return new String(text.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public static Properties getProperties() {
        return properties;
    }

    /**
     * @return Get the path to your source directory with a / at the end
     */
    private static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
