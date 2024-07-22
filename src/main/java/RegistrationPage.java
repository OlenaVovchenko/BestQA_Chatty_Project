import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
        private static boolean registrationPageDisplayed;
    // public RegistrationPage(WebDriver driver) {
     //   super(driver);
  //  }

    @FindBy(css = "[name=\"email\"]")
    private WebElement emailEditBox;

    @FindBy(css = ".input-password")
    private WebElement passwordEditBox;

    @FindBy(tagName = "button")
    private WebElement registrationButton;

    @FindBy(id = "successMessage")
    private WebElement successMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public static boolean isRegistrationPageDisplayed() {
        return registrationPageDisplayed;
    }

    public static void setRegistrationPageDisplayed(boolean registrationPageDisplayed) {
        RegistrationPage.registrationPageDisplayed = registrationPageDisplayed;
    }


    public RegistrationPage open() {
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        emailEditBox.sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        passwordEditBox.sendKeys(password);
        return this;
    }

    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    public boolean isRegistrationSuccessful() {
        return successMessage.isDisplayed();
    }

    public HomePage clickButton() {
        clickRegistrationButton().clickButton();
        return this.clickButton();
    }
}

