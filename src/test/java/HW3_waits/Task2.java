package HW3_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Task2 extends BaseTest {

    private static final String URL = "http://the-internet.herokuapp.com/dynamic_controls";
    private static final By BUTTON = By.xpath("//form[@id='checkbox-example']/button");
    private static final By CHECKBOX = By.cssSelector("input#checkbox");

    @Test
    public void testCheckBox() {

        driver.get(URL);
        driver.findElement(BUTTON).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(explicitTimeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .until(driver1 -> driver.findElement(BUTTON).isEnabled());
        driver.findElement(BUTTON).click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(explicitTimeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .until(driver1 -> driver.findElement(BUTTON).isEnabled());
        Assert.assertTrue(driver.findElement(CHECKBOX).isDisplayed(), "чекбокс не появился");
    }
}
