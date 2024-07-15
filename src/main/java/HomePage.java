import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@class=\"posts__section\"]")
    private WebElement postSection;
    @FindBy(xpath = "//*[@data-test=\"post-header__plus\"]")
    private WebElement postCreationButton;
    @FindBy(xpath = "//*[@name=\"title\"]")
    private WebElement titleEditBox;
    @FindBy(xpath = "//*[@placeholder=\"Description\"]")
    private WebElement descriptionEditBox;
    @FindBy(xpath = "//*[@name=\"content\"]")
    private WebElement contentEditBox;
    @FindBy(xpath = "//*[@class=\"post_uploaded_image__7qSWV\"]")
    private  WebElement imageField;
    @FindBy(xpath = "//*[@type=\"file\"]")
    private WebElement inputFile;
    @FindBy(xpath = "//label[@for='draftCheckbox']")
    private WebElement saveAsDraftToggle;
    @FindBy(xpath = "//*[@data-test=\"submit\"]")
    private WebElement submitPostButton;
    @FindBy(xpath = "//span[text()='My drafts']")
    private WebElement myDraftsButton;
    @FindBy(xpath = "//*[@href=\"/contact\"]")
    private WebElement contactUsButton;

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
    public HomePage clickPostCreationButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(postCreationButton));
        postCreationButton.click();
        return this;
    }
    public HomePage fillInTitleEditBox(String title) {
        titleEditBox.sendKeys(title);
        return this;
    }
    public HomePage fillInDescriptionEditBox(String description) {
        descriptionEditBox.sendKeys(description);
        return this;
    }
    public HomePage fillInContentEditBox(String content) {
        contentEditBox.sendKeys(content);
        return this;
    }
    public HomePage attachImageToImageField(String fileName) {
        String filePath = Paths.get("src/main/resources", fileName).toAbsolutePath().toString();
        inputFile.sendKeys(filePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(saveAsDraftToggle));
        return this;
    }
    public HomePage clickOnSaveAsDraftToggle() {
        saveAsDraftToggle.click();
        return this;
    }
    public HomePage clickOnSubmitPostButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitPostButton));
        submitPostButton.click();
        return this;
    }
    public DraftPage clickOnMyDraftsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myDraftsButton));
        myDraftsButton.click();
        return new DraftPage(driver);
    }
    public ContactUsPage clickOnContactUsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myDraftsButton));
        contactUsButton.click();
        return new ContactUsPage(driver);
    }
}

