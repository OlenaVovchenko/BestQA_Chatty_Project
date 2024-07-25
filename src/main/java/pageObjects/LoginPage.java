package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@name=\"email\"]")
    private WebElement emailEditBox;
    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement passwordEditBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class='form']")
    private WebElement formElement;
    @FindBy(xpath = "//*[@href='/registration']")
    private WebElement signUpLink;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/p/a")
    private WebElement signInButton;
    @FindBy(xpath = "(//*[@class=\"text-error\"])[1]")
    private WebElement emailErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }

    public LoginPage enterEmail(String email) {
        emailEditBox.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordEditBox.sendKeys(password);
        return this;
    }

    public HomePage clickButton() {
        loginButton.click();
        return new HomePage(driver);
    }

    public boolean isFormElementDisplayed() {
        return formElement.isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        return emailErrorMessage.isDisplayed();
    }

    public CreateAccountPage clickOnSignIn() {
        signInButton.click();
        return new CreateAccountPage(driver);
    }
}
