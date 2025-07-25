package webapp.pages.Project;

import main.java.core.base.TestBase;
import org.openqa.selenium.By;
import webapp.testdata.Constants;

import static core.utils.NameGenerator.generateRandomName;

public class AccessTradePage extends TestBase {
    static final By backlogQuickAddBtn = By.xpath("//span[text()='Backlog']/ancestor::div[contains(@class, 'o_kanban_header_title')]/button/*[@title='Quick add']");

    static final By taskTitleInput = By.cssSelector("input[id='display_name_0']");
    static final By assigneesInput = By.cssSelector("input[id='user_ids_0']");
    static final By addBtn = By.xpath("//*[contains(@class, 'o_kanban_add')]");
    static final By editBtn = By.xpath("//*[contains(text(), 'Edit']");
    static final By deleteBtn = By.xpath("//*[contains(@class, 'o_kanban_cancel')]");
    static String taskTitleString = "//article/main/*[contains(text(), '%s')]";
    static final By firstAssignee = By.cssSelector("*[id='user_ids_0_0_0']");

    public static boolean isTaskCreated(String taskTitle) {
        By ticketTitle = By.xpath(String.format(taskTitleString, taskTitle));
        return actions.isElementDisplayed(ticketTitle);
    }
    public static void addBacklogTicket(String taskTitle) {
        actions.click(backlogQuickAddBtn);
        actions.textBoxInput(taskTitleInput, taskTitle);
        actions.click(assigneesInput);
        actions.click(firstAssignee);
        actions.click(addBtn);
    }

}
