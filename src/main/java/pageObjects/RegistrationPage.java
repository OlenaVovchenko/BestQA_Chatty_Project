package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@placeholder='Confirm password']")
    private WebElement inputConfirmPassword;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[@class='text-error']")
    private WebElement errorMessage;


    public RegistrationPage enterEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage enterConfirmPassword(String confirmpassword) {
        inputConfirmPassword.sendKeys(confirmpassword);
        return this;
    }

    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    public boolean isErrorMessageDisplayed(String text) {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText().contains(text);
    }
}