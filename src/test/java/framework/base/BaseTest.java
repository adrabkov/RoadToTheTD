package framework.base;

import a1qa.selenium.browser.Browser;
import a1qa.selenium.browser.BrowserManager;
import aqa.logger.Logger;
import framework.configurations.Configuration;
import framework.enums.TestStatus;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected final Logger logger = Logger.getInstance();

    /**
     * To override.
     */
//    protected abstract void runTest();

    /**
     * Before Class method
     * Configure environment
     * Make a browser window
     */
    @BeforeMethod
    public void before() throws WebDriverException, MalformedURLException {
        logger.logPreconditions();
        getBrowser().goTo(Configuration.getCurrentEnvironment().getStartUrl());
        getBrowser().setSize(1920, 1080);
    }

    /**
     * Close browser and made screenshot after each test Class
     */
    @AfterMethod
    public void afterMethod(ITestContext testContext, ITestResult testResult) {
        TestStatus testStatus;
        if (testResult.getStatus() == TestResult.SUCCESS) {
            testStatus = TestStatus.PASSED;
        } else {
            testStatus = TestStatus.FAILED;
        }
        logger.logFormattedMessage(Logger.getLoc("loc.base.test.testEnd"), testContext.getName(), testStatus.toString(),
                formatDuration(testResult.getEndMillis() - testResult.getStartMillis()));
        getBrowser().quit();
    }

    private String formatDuration(long milliseconds) {
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds - TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));
        return logger.getFormattedMessage(Logger.getLoc("loc.base.test.duration"), hours, minutes, seconds);
    }

    private Browser getBrowser() {
        return BrowserManager.getBrowser();
    }
}
