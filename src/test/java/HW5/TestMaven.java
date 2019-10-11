package HW5;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMaven extends BaseTest {
    private static final String URL = "https://profile.onliner.by/login";
    private static final By LOGINFIELD = By.xpath("//input[@class][@placeholder=\"Ник или e-mail\"]");
    private static final By PASSWORDFIELD = By.xpath("//input[@class][@placeholder=\"Пароль\"]");
    private static final By SUBMITFIELT = By.xpath("//div/button");
    private static final By EMAIL = By.xpath("//div[@class= 'profile-form__set-item profile-form__set-item_email']//span");
    private static final String PERSONALPAGE = "https://profile.onliner.by/personal";
    private static final By LOGO = By.xpath("//div[@class = \"b-top-profile__image js-header-user-avatar\"]");
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final Duration POLLINGFREQUENCY = Duration.ofSeconds(2);

    @Test
    @Parameters({"login", "password"})
    public void test(String login, String password) {

        driver.get(URL);

        log.info("Logging to account");
        driver.findElement(LOGINFIELD).sendKeys(login);
        driver.findElement(PASSWORDFIELD).sendKeys(password);
        driver.findElement(SUBMITFIELT).click();
        new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLINGFREQUENCY)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(LOGO)));

        log.info("Going to the page with personal information");
        driver.navigate().to(PERSONALPAGE);

        log.info("Email Verification");
        Assert.assertEquals(driver.findElement(EMAIL).getText(), login, "invalid email address");
        log.info("You are logged in as: " + login);
    }
}
