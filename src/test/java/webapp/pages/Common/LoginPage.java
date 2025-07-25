package webapp.pages.Common;

import main.java.core.base.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {
    static final By emailInput = By.cssSelector("input[name='login']");
    static final By passwordInput = By.cssSelector("input[name='password']");
    static final By loginBtn = By.xpath("//*[contains(text(), 'Log in')]");

    public static void loginToSystem(String username, String password) {
        actions.textBoxInput(emailInput, username);
        actions.textBoxInput(passwordInput, password);
        actions.click(loginBtn);
    }
}
