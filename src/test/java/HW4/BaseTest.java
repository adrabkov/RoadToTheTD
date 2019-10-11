package HW4;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static Logger log = LogManager.getLogger();

    @BeforeMethod
    public void setUpBrowser() {
        log.info("Browser starting");
        driver = Browser.getInstance().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Browser.getInstance().getDriver().close();
        log.info("Browser closed");
    }
}
