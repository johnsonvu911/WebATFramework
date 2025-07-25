package webapp.testcases;

import main.java.core.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import webapp.pages.Common.LoginPage;
import webapp.pages.Dashboard.DashboardPage;
import webapp.pages.Project.AccessTradePage;
import webapp.pages.Project.ProjectsPage;
import webapp.testdata.Constants;

public class VerifyProjectTicket extends TestBase {
    String taskTitle = core.utils.NameGenerator.generateRandomName(20);

    @Test(description = "Verify ticket is created successfully", groups = {"regression", "smoke"}, priority = 1)
    public void createTicketSuccessfully() {
        actions.navigateTo(Constants.testSite);
        LoginPage.loginToSystem(Constants.loginEmail, Constants.loginPassword);
        DashboardPage.accessProjectApp();
        ProjectsPage.accessAccessTradeProject();
        AccessTradePage.addBacklogTicket(taskTitle);
        // CHECKPOINT
        Assert.assertTrue(AccessTradePage.isTaskCreated(taskTitle));
    }

    @Test(description = "Verify ticket is NOT created successfully", groups = {"regression", "e2e"}, priority = 2)
    // This test case is intentionally for failing to capture screenshot.
    public void FailToCreateTicket() {
        actions.navigateTo(Constants.testSite);
        LoginPage.loginToSystem(Constants.loginEmail, Constants.loginPassword);
        DashboardPage.accessProjectApp();
        ProjectsPage.accessAccessTradeProject();
        AccessTradePage.addBacklogTicket(taskTitle);
        // CHECKPOINT
        Assert.assertFalse(AccessTradePage.isTaskCreated(taskTitle));
        }

}
