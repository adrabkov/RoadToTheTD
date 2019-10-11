package HW3_waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static PropertyManager globalConfig = new PropertyManager("timeout");
    public static long explicitTimeout = Long.parseLong(globalConfig.getSystemProperty("explicittimeout"));
    public static long pageLoadTime = Long.parseLong(globalConfig.getSystemProperty("pageload"));
    public static long pollingEvery = Long.parseLong(globalConfig.getSystemProperty("pollingEvery"));

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", getPathToDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    private String getDriverName() {

        final String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            return "chromedriver.exe";
        } else if (OS.contains("mac")) {
            return "chromedrivermac";
        }
        return "chromedriverlinux";
    }

    private String getPathToDriver() {

        String path = "";
        java.net.URL myTestURL = ClassLoader.getSystemResource(getDriverName());
        try {
            path = new File(myTestURL.toURI()).getAbsolutePath();
        } catch (URISyntaxException e1) {
            System.out.println(e1.getMessage());
        }
        return Objects.requireNonNull(path);
    }

}
