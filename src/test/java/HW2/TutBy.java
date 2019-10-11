package HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TutBy {
    private static final String URL = "https://www.tut.by/";
    private static final String EMAIL = "a1qatest@tut.by";
    private static final String PASS = "Qwerty123";
    private static final String USERNAME = "Tester Testov";
    private static final String DIVER_PROPERTY = "webdriver.chrome.driver";
    private WebDriver driver;

    private void baseTestParam() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @BeforeMethod
    public void setUp() {
        String osName = System.getProperty("os.name");
        String driverName;
        if (osName.contains("mac")) {
            driverName = "chromedriver_mac64";
        } else if (osName.contains("nux")) {
            driverName = "chromedriver_linux64";
        } else {
            driverName = "chromedriver.exe";
        }
        System.setProperty(DIVER_PROPERTY, driverName);
        baseTestParam();
    }

    @Test
    public void testCheckUserName() {
        driver.findElement(By.cssSelector(".enter")).click();
        driver.findElement(By.cssSelector("[name=\"login\"]")).sendKeys(EMAIL);
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(PASS);
        driver.findElement(By.xpath("//input[contains(@class,'auth__enter')]")).click();
        String userName = driver.findElement(By.className("uname")).getText();
        Assert.assertEquals(userName, USERNAME, "Username does not match!!!");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
