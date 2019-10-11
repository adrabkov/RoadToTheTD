package HW3_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Task3 extends BaseTest {
    private static final String EXPECTEDTEXT = "Hello World!";
    private static final String URL = "http://the-internet.herokuapp.com/dynamic_loading/1 ";
    private static final By STARTBUTTON = By.cssSelector("div#start>button");
    private static final By HELLOTEXT = By.cssSelector("div#finish");

    @Test
    public void testHelloWorld() {

        driver.get(URL);
        WebElement hello = driver.findElement(HELLOTEXT);
        Assert.assertFalse(hello.isDisplayed(), "элемент с текстом " + EXPECTEDTEXT + " отображается");
        driver.findElement(STARTBUTTON).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(explicitTimeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .until(ExpectedConditions.textToBe(HELLOTEXT, "Hello World!"));
        String text = driver.findElement(HELLOTEXT).getText();
        Assert.assertEquals(text, EXPECTEDTEXT, "элемент с надписью " + EXPECTEDTEXT + " не найден");
    }
}
