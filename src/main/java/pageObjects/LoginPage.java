package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@class='form']")
    private WebElement formElement;
    @FindBy(xpath = "//*[@name=\"email\"]")
    private WebElement emailEditBox;
    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement passwordEditBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@href='/registration']")
    private WebElement signUpLink;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }


    public boolean isFormElementDisplayed() {
        return formElement.isDisplayed();

    }

    public RegistrationPage clickSignUp() {
        signUpLink.click();
        return new RegistrationPage(driver);
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


}
