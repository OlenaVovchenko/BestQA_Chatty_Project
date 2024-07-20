import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {
    @FindBy(id = "name")
    private WebElement nameEditBoxInContact;
    @FindBy(id = "email")
    private WebElement emailEditBoxInContact;
    @FindBy(id = "content")
    private WebElement contentEditBoxInContact;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement buttonSendMessageInContact;
    @FindBy(xpath = "//*[@class=\"success-message\"]")
    private WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage fillNameInEditBoxInContact(String text) {
        nameEditBoxInContact.sendKeys(text);
        return this;
    }

    public ContactUsPage fillEmailInEditBoxInContact(String text) {
        emailEditBoxInContact.sendKeys(text);
        return this;
    }

    public String getEmailValidationMessage() {
        return emailEditBoxInContact.getAttribute("validationMessage");
    }

    public ContactUsPage fillContentInEditBoxInContact(String text) {
        contentEditBoxInContact.sendKeys(text);
        return this;
    }

    public ContactUsPage clickOnButtonSendMessage() {
        buttonSendMessageInContact.click();
        return this;
    }

    public boolean isSuccessMessageDisplay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }
}
