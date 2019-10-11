package HW5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

class Browser {
    private static Browser browser;
    private WebDriver driver;

    private Browser() {
    }

    static Browser getInstance() {
        if (browser == null) {
            init();
        }
        return browser;
    }

    private static void init() {
        browser = new Browser();
        browser.initDriver();
    }

    WebDriver getDriver() {
        return driver;
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", getPathToDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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

    private String getDriverName() {
        final String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            return "chromedriver.exe";
        } else if (OS.contains("mac")) {
            return "chromedrivermac";
        }
        return "chromedriverlinux";
    }
}

