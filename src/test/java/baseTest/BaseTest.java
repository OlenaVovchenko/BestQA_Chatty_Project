package baseTest;

import drivers.ChromeRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected WebDriver driver;
    @BeforeEach
    public void setUp() {
        ChromeRegistry chromeRegistry = new ChromeRegistry();
        driver = chromeRegistry.registerDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}