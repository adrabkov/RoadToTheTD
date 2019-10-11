import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    private static final String URL = "https://www.seleniumhq.org/";
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(enabled = false)
    public void testSelenium() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, URL);
    }

    @Test
    public void testDonateButton() {
        List<String> tabNames = new ArrayList<String>();
        tabNames.add("about");
        tabNames.add("support");
        tabNames.add("documentation");
        tabNames.add("download");
        tabNames.add("projects");
        for (String tabName : tabNames) {
            driver.findElement(By.xpath("//li[@id='menu_" + tabName + "']")).click();
            WebElement donateForm = driver.findElement(By.cssSelector("form[action='https://www.paypal.com/cgi-bin/webscr'"));
            Assert.assertTrue(donateForm.isDisplayed(), "Donate is not displayed on the "+ tabName +" tab");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
