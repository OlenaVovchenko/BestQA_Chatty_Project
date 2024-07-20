import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraftPage extends BasePage {
    @FindBy(xpath = "//*[@class=\"post-content__top\"]")
    private WebElement textTitleInDraft;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextTitleInDraftPresent(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textTitleInDraft));
        return textTitleInDraft.getText().contains(text);
    }
}
