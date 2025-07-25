package main.java.core.driver;

import main.java.core.data.Constants;
import main.java.core.enums.Target;
import main.java.core.exceptions.TargetNotValidException;
import main.java.core.utils.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TargetFactory {
    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(Constants.TARGET.toUpperCase());
        WebDriver webdriver;

        switch (target) {
            case LOCAL:
                //Create new driver from Enum setup in BrowserFactory class
                webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
                break;
            case REMOTE:
                //Create new driver on Cloud (Selenium Grid, Docker) from method below
                webdriver = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return webdriver;
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", Constants.REMOTE_URL, Constants.REMOTE_PORT);

            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        } catch (java.net.MalformedURLException e) {
            Logger.error("Grid URL is invalid or Grid Port is not available");
            Logger.error(String.format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            Logger.error(String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }

        return remoteWebDriver;
    }
}
