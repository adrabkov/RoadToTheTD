package HW4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTask extends BaseTest {

    private static final String URL = "http://the-internet.herokuapp.com/nested_frames";
    private static final By XPATH_FRAME = By.xpath("//frame");
    private static final By BODY = By.cssSelector("body");

    @Test
    public void testFindFrames() {

        driver.get(URL);
        List<WebElement> frame = driver.findElements(XPATH_FRAME);
        int size = driver.findElements(XPATH_FRAME).size();

        for (WebElement list : frame) {
            driver.switchTo().defaultContent()
                    .switchTo().frame(list);
            if (driver.findElements(XPATH_FRAME).size() > 0) {
                for (int i = 0; i <= size; i++) {
                    driver.switchTo().frame(i);
                    log.info(driver.findElement(BODY).getText());
                    driver.switchTo().parentFrame();
                }
            } else {
                log.info(driver.findElement(BODY).getText());
            }
        }
    }
}

