package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

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

    @FindBy(xpath = "//*[@data-test='post']")
    private List<WebElement> personalPosts;

    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement postCreateButton;

    @FindBy(xpath = "//input[@name='title']")
    private WebElement postTitleField;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement postDescriptionField;

    @FindBy(xpath = "//textarea[@name='content']")
    private WebElement postMyThoughtsField;

    @FindBy(xpath = "//*[@type=\"file\"]")
    private WebElement inputFile;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement postSubmitButton;

    @FindBy(xpath = "//*[@href='/about']")
    private WebElement aboutLink;

    @FindBy(xpath = "//*[@href='/contact']")
    private WebElement contactLink;

    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public boolean isPostSectionDisplayed() {
            wait.until(ExpectedConditions.visibilityOf(postSection));
            return postSection.isDisplayed();

    }

    public HomePage clickPostsToggle() {
         wait.until(ExpectedConditions.elementToBeClickable(myPostsToggle)).click();
        return this;
    }

    public boolean isPostPhotoDisplayed() {
         wait.until(ExpectedConditions.visibilityOf(postPhoto));
         return postPhoto.isDisplayed();

        }


    public boolean isPostTitleDisplayed() {
           wait.until(ExpectedConditions.visibilityOf(postTitle));
            return postTitle.isDisplayed();

    }

    public boolean isPostDescriptionDisplayed() {
          wait.until(ExpectedConditions.visibilityOf(postDescription));
          return postDescription.isDisplayed();

    }

    public boolean allPersonalPostsAreDisplayed() {
        boolean allPersonalPostsAreDiplayed = true;
        for (WebElement post : personalPosts) {
            if (!post.isDisplayed()) {

                allPersonalPostsAreDiplayed = false;
            }
        }
        return allPersonalPostsAreDiplayed;
    }


    public int getPostsQuantity() {
          wait.until(ExpectedConditions.visibilityOfAllElements(personalPosts));
         return personalPosts.size();

    }

    public PostPage clickPost() {
        wait.until(ExpectedConditions.visibilityOfAllElements(postTitle));
        postTitle.click();
        return new PostPage(driver);

    }

    public AboutChattyPage clickOnAboutLink() {
        aboutLink.click();
        return new AboutChattyPage(driver);
    }

    public ContactUsPage clickOnContactLink() {
        contactLink.click();
        return new ContactUsPage(driver);
    }

    public HomePage clickCreatePostPlusButton() {
        postCreateButton.click();
        return this;

    }

    public HomePage enterPostTitle(String title) {
         wait.until(ExpectedConditions.visibilityOf(postTitleField)).sendKeys(title);
        return this;
    }

    public HomePage enterPostDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(postDescriptionField)).sendKeys(description);
        return this;
    }

    public HomePage enterMyThoughts(String area) {
        wait.until(ExpectedConditions.visibilityOf(postMyThoughtsField)).sendKeys(area);
        return this;

    }


    public HomePage attachImageToImageField(String fileName) {
        String filePath = Paths.get("src/main/resources", fileName).toAbsolutePath().toString();
        inputFile.sendKeys(filePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return this;
    }


    public HomePage clickPostButton() {
         wait.until(ExpectedConditions.elementToBeClickable(postCreateButton)).click();
        return this;
    }

    public boolean isPostTitlePresent() {
         return postTitle.isDisplayed();


    }
}







