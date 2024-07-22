package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = "src" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "resources" +
            FILE_SEPARATOR + "screenshots" + FILE_SEPARATOR;

    private ScreenshotUtil() {
    }

    public static void captureScreen(WebDriver driver, String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),
                    new File(PATH + name + System.currentTimeMillis() + ".png"));
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found - file NotFoundexception");
        } catch (IOException ex) {
            System.out.println("Input/output exception");
        }
    }
}