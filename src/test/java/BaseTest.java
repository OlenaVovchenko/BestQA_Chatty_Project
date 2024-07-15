import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import util.ScreenshotUtil;
import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {
    protected WebDriver driver;
    @BeforeEach
    public void setUp() {
        ChromeRegistry chromeRegistry = new ChromeRegistry();
        driver = chromeRegistry.registerDriver();
        driver.manage().window().maximize();
    }
    public void defineTestResultTrue(boolean condition) {
        try {
            assertTrue(condition, "Expected condition to be true.");
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, this.getClass().getSimpleName());
            throw e;
        }
    }
    @AfterEach
    public void quit () {
        driver.quit();
    }
}

