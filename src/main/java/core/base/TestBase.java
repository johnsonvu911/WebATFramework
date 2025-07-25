package main.java.core.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.core.driver.DriverManager;
import main.java.core.driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public ExtentSparkReporter reporter;
    public static ExtentReports report;
    public static ExtentTest logger;
    public static ElementActions actions;

    @BeforeTest
    public void beforeTest() {
        actions = new ElementActions();
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "QAAutomationReport.html");
        reporter.config().setEncoding("utf-8");
        reporter.config().setDocumentTitle("QA Automation Report");
        reporter.config().setReportName("QA Automation Test Results");
        reporter.config().setTheme(Theme.DARK);
        report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("Tester", "Son Vu");

    }
    @BeforeMethod
    @Parameters( value={"browser"})
    public void beforeMethod(@Optional String browser, Method testMethod) {
        openBrowser(browser);
        logger = report.createTest(testMethod.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if(result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, markup);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP, markup);
        }
        if (driver != null) {
            driver.close();
        }
    }
    @AfterTest
    public void afterTest() {
        report.flush();
        if (driver != null) {
            driver.quit();
        }
    }

    public void openBrowser(String browser) {
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private void setupDriver(String browser) {
        driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }
}
