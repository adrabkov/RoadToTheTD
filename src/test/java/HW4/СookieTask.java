package HW4;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class СookieTask extends BaseTest {

    private static final String URL = "http://the-internet.herokuapp.com/login";
    private static final String USER_NAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String LOGOUT = "//i[@class='icon-2x icon-signout']";
    private static final String SIGNIN = "//i[@class='fa fa-2x fa-sign-in']";
    private static final String WELCOM_TEXT = "Welcome to the Secure Area. When you are done click logout below.";

    @Test
    public void test() {
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("username")).sendKeys(USER_NAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector(".radius>i")).click();
        Assert.assertTrue(driver.findElement(By.xpath(LOGOUT)).isDisplayed(), "User is not authorized");

        log.info("User logged");
        log.info("Getting cookies");
        Set<Cookie> cookies = driver.manage().getCookies();

        log.info("Close existing instance and create new one");
        driver = Browser.getInstance().closeExistingAndCreateNewOne();

        driver.navigate().to(URL);
        driver.manage().deleteAllCookies();

        log.info("Check that the user is not logged in");
        Assert.assertTrue(driver.findElement(By.xpath(SIGNIN)).isDisplayed(), "The user is authorized");
        log.info("The user is not logged in");

        log.info("Set cookie");
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        driver.navigate().to("http://the-internet.herokuapp.com/secure");

        log.info("Checking for text: " + WELCOM_TEXT);
        Assert.assertTrue(driver.findElement(By.cssSelector(".subheader")).getText().contains(WELCOM_TEXT), "Authorization failed!!");
        log.info("Test completed");
    }
}
