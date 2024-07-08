import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage{
    @FindBy(xpath = "//*[@class=\"posts__section\"]")
    private WebElement postSection;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isPostSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(postSection));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

