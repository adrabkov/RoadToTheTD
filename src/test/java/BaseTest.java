import driver.DriverHolder;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final String URL = "https://www.kinopoisk.ru";
    private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

    @BeforeMethod
    public void setUp() {
        log.info("Starting browser");
        WebDriver driver = DriverHolder.getInstance();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        log.info("Closing browser");
        DriverHolder.clean();
    }


}
