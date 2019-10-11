package HW4;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AdditionalTask extends BaseTest {

    private static final String URL = "http://the-internet.herokuapp.com/hovers";
    private static final String FIGURE = "//div[@class='figure'][1]";
    private static final String FIG_CAPTION = "//div[@class='figcaption'][1]/h5";
    private static final String EXP_TEXT = "name: user1";

    @Test
    public void test() {

        driver.get(URL);
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath(FIGURE))).build().perform();

        Assert.assertTrue(driver.findElement(By.xpath(FIG_CAPTION)).getText().contains(EXP_TEXT), EXP_TEXT + " is not displayed");
        log.info(EXP_TEXT + " is displayed");
    }
}
