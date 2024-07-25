package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class DraftPage extends BasePage {
    @FindBy(xpath = "//*[@class=\"post-content__top\"]")
    private WebElement textTitleInDraft;
    @FindBy(xpath = "//*[@data-test='draft-posts']")
    private WebElement draftPostCaption;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextTitleInDraftPresent(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textTitleInDraft));
        return textTitleInDraft.getText().contains(text);
    }
    public boolean isHereCanBeYourPostsTextPresent() {
        return draftPostCaption.isDisplayed();
    }
}
