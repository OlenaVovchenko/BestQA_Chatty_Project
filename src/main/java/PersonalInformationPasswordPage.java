import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPasswordPage extends BasePage {


    @FindBy(xpath = "//*[@class='PasswordModal_password_modal__O8ESn']")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@placeholder='Old password']")
    private WebElement inputOldPassword;

    @FindBy(xpath = "//*[@placeholder='New password']")
    private WebElement inputNewPassword;


    @FindBy(xpath = "//*[@placeholder='Confirm new password']")
    private WebElement inputConfirmNewPassword;


    @FindBy(xpath = "//button[@class='PasswordModal_pass_btn__eGL9h']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@class='PasswordModal_error__9a5OG']")
    private WebElement errorMessage;

    public PersonalInformationPasswordPage(WebDriver driver) {
        super(driver);

    }
    public boolean isPasswordBoxDisplayed() {
        return passwordBox.isDisplayed();
    }


    public PersonalInformationPasswordPage inputOldPassword(String password) {
        inputOldPassword.sendKeys(password);
        return this;
    }


    public PersonalInformationPasswordPage inputNewPassword(String password) {
        inputNewPassword.sendKeys(password);
        return this;
    }


    public PersonalInformationPasswordPage confirmNewPassword(String password) {
        inputConfirmNewPassword.sendKeys(password);
        return this;
    }

    public PersonalInformationPasswordPage clickSaveButton() {
        saveButton.click();
        return this;

    }

    public boolean isErrorMessageDisplayed(String text) {
        return errorMessage.getText().contains(text);

    }
}