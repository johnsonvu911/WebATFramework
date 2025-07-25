package main.java.core.data;

import main.java.helpers.PropertiesHelpers;
public final class Constants {
    private Constants() {}

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public static final int DEFAULT_TIMEOUT = 10000;
    public static final int SHORT_TIMEOUT = 5000;
    public static final int LONG_TIMEOUT = 30000;

    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public static final String URL_TEST = PropertiesHelpers.getValue("URL_CPP");
    public static final String REMOTE_URL = PropertiesHelpers.getValue("REMOTE_URL");
    public static final String REMOTE_PORT = PropertiesHelpers.getValue("REMOTE_PORT");
    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");
    public static final String TARGET = PropertiesHelpers.getValue("TARGET");

}
