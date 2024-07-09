import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@class='posts__section']")
    private WebElement postSection;

    @FindBy(xpath = "//label[@for='myPostsId']")
    private WebElement myPostsToggle;

    @FindBy(xpath = "//*[@src='https://chatty-images-s3.s3.eu-central-1.amazonaws.com/0088aaf0-efbe-471b-8279-01128e442c01/e28b93b4-77a6-4a57-91b0-1a9abaa2a3fe.jpeg']")
    private WebElement postPhoto;

    @FindBy(xpath = "//*[@class='post-content__top']")
    private WebElement postTitle;

    @FindBy(xpath = "//*[@class='post__description']")
    private WebElement postDescription;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPostSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(postSection));
            return postSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public HomePage clickPostsToggle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myPostsToggle)).click();
        return this;
    }

    public boolean isPostPhotoDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(postPhoto));
            return postPhoto.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPostTitleDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(postTitle));
            return postTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPostDescriptionDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(postDescription));
            return postDescription.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
