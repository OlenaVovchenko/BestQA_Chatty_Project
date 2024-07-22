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



        @AfterEach
        public void quit () {
            driver.quit();
        }

    public void defineTestResultEquals(Object expected, Object actual) {
        String name = this.getClass().getName();
        try {
            assertEquals(expected, actual);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
            fail("TEST FAILED");
        }
    }

    public void defineTestResultTrue(boolean condition) {
        String name = this.getClass().getName();
        try {
            assertTrue(condition);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
           fail("TEST FAILED");
        }
    }

    public void defineTestResultFalse(boolean condition) {
        String name = this.getClass().getName();
        try {
            assertFalse(condition);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
           fail("TEST FAILED");
        }
    }
    }
