import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeRegistry {
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = "." +  FILE_SEPARATOR +  "src" +  FILE_SEPARATOR + "main" +  FILE_SEPARATOR
            + "resources" +  FILE_SEPARATOR + "chromedriwer-win64" +  FILE_SEPARATOR +  "chromedriver";

    public ChromeDriver registerDriver(){
        System.setProperty("webdriver.chrome.driver", PATH);
        return  new ChromeDriver();
    }
}

