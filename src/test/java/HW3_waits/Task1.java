package HW3_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Task1 extends BaseTest {

    private static final String URL = "https://www.tut.by/";
    private static final String EXPREZ = "42";
    private static final By TOPBAR = By.cssSelector("div[class='b-topbar-more active']");

    @Test
    public void test42page() {

        driver.get(URL);
        Assert.assertEquals(driver.findElements(TOPBAR).size(), 0, "всплывающее меню 'Разделы' не скрыто");
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(explicitTimeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .until(ExpectedConditions.invisibilityOfElementLocated(TOPBAR));
        driver.findElement(By.xpath("//span[contains(@class, 'icon-burger')]")).click();
        driver.findElement(By.xpath("//a[@title='42'][@class]")).click();
        String title = driver.findElement(By.xpath("//a[@class='name-resource'][@title]")).getText();
        Assert.assertEquals(title, EXPREZ, "Мы не на главное странице");
    }
}
