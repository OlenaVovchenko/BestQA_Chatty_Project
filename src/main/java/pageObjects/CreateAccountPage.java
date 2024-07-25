package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BasePage {
    @FindBy(xpath = "//*[@name=\"email\"]")
    private WebElement emailEditBox;

    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement passwordEditBox;

    @FindBy(xpath = "//*[@name=\"confirmPassword\"]")
    private WebElement confirmPasswordEditBox;

    @FindBy(xpath = "//*[@class=\"registration-btn\"]")
    private WebElement registrationButton;

    @FindBy(xpath = "(//*[@class=\"text-error\"])[1]")
    private WebElement passwordErrorMessage;


    public CreateAccountPage (WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage inputEmail(String email) {
        emailEditBox.sendKeys(email);
        return this;
    }

    public CreateAccountPage inputPassword(String password) {
        passwordEditBox.sendKeys(password);
        return this;
    }

    public CreateAccountPage inputConfirmPassword(String confirmPassword) {
        confirmPasswordEditBox.sendKeys(confirmPassword);
        return this;
    }

    public HomePage clickRegistrationButton() {
        registrationButton.click();
        return new HomePage(driver);
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
    public boolean isPasswordErrorMessagePresent(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordErrorMessage));
        return passwordErrorMessage.getText().contains(text);
    }

}