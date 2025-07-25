package webapp.pages.Dashboard;

import main.java.core.base.TestBase;
import org.openqa.selenium.By;

public class DashboardPage extends TestBase {
    static final By projectAppIcon = By.cssSelector("a[href='/odoo/project']");

    public static void accessProjectApp() {
        actions.click(projectAppIcon);
    }
}
