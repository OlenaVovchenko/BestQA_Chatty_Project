package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostPage extends BasePage {
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@data-test='post']")
    private WebElement personalPost;

    @FindBy(xpath = "//*[@src='https://chatty-images-s3.s3.eu-central-1.amazonaws.com/0088aaf0-efbe-471b-8279-01128e442c01/87ae52f7-95ff-48df-99c5-d8cc9abd2c68.jpeg']")
    private WebElement postPhoto;

    @FindBy(xpath = "//*[@class='post-content__top']")
    private WebElement postTitle;

    @FindBy(xpath = "//*[@class='post__description']")
    private WebElement postDescription;

    public PostPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isPostTitleDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(postTitle));
        return postTitle.isDisplayed();
    }

    public boolean isPostDescriptionDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(postDescription));
        return postDescription.isDisplayed();
    }

    public boolean isPostPhotoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(postPhoto));
        return postPhoto.isDisplayed();
    }
}