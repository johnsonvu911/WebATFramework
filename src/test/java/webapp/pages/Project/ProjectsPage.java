package webapp.pages.Project;

import main.java.core.base.TestBase;
import org.openqa.selenium.By;

public class ProjectsPage extends TestBase {
    static final By AccessTradeProject = By.xpath("//*[contains(text(), 'AccessTrade')]");
    static final By newButton = By.xpath("//*[contains(text(), 'New')]");
    static final By actionsIcon = By.cssSelector("button[data-tooltip='Actions']");
    static final By projectStatusBtn = By.xpath("//*[name='last_update_status]'/button/div/span");

    public static void accessAccessTradeProject() {
        actions.click(AccessTradeProject);
    }
}
