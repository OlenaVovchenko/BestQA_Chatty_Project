package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage extends BasePage {

    @FindBy(xpath = "//*[@data-test='draft-posts']")
    private WebElement draftPostCaption;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHereCanBeYourPostsTextPresent() {
        return draftPostCaption.isDisplayed();
    }

}
