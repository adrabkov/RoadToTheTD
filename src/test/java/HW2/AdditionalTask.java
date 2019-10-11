package HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AdditionalTask {
    private static final String URL = "https://www.seleniumhq.org/";
    private WebDriver driver;

    @BeforeClass
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

    @DataProvider (name = "tabNames")
    public Object[][] tabs(){
        return new Object[][]{{"about"}, {"support"}, {"documentation"}, {"download"}, {"projects"}};
    }

    @Test(dataProvider = "tabNames")
    public void testDonateButton(String tabName) {
            driver.findElement(By.xpath("//li[@id='menu_" + tabName + "']")).click();
            WebElement donateForm = driver.findElement(By.cssSelector("form[action='https://www.paypal.com/cgi-bin/webscr'"));
            Assert.assertTrue(donateForm.isDisplayed(), "Donate is not displayed on the "+ tabName +" tab");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
