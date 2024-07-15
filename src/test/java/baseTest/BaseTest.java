package baseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import util.ScreenshotUtil;
import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {
    protected static WebDriver driver;

    public void maximizeBrowserWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

//    @BeforeAll
//    public static void startBeforeAllTests(WebDriver driver) {
//        driver.manage().window().maximize();
////        driver.get("http://chatty.telran-edu.de:8089/login");
//    }

//    @BeforeEach
//    public void startEachTest() {
////       driver.get("http://chatty.telran-edu.de:8089/login");

//}


//    @AfterAll
//    public static void quitAfterAllTests() {
//        driver.quit();
//    }


    //    public void defineTestResultTrue(boolean condition) {
//        try {
//            assertTrue(condition);
//        } catch (AssertionError e) {
//            ScreenshotUtil.captureScreen(driver, this.getClass().getName());
//            fail("TEST FAILED: " + e.getMessage()); // Передача сообщения об ошибке в fail
//        }
//    }
    public void defineTestResultTrue(boolean condition) {
        try {
            assertTrue(condition, "Expected condition to be true.");
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, this.getClass().getSimpleName());
            throw e;  // Переброс исключения после логирования и создания скриншота
        }

    }
}