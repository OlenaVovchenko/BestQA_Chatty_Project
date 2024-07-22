/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@name=\"email\"]")
    private WebElement emailEditBox;
    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement passwordEditBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;

@FindBy(xpath =  "//*[@id=\"root\"]/div/div/p/a")
private WebElement signInButton;

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
    public HomePage clickButton(){
        loginButton.click();
        return new HomePage(driver);
    }
    public CreateAccountPage clickOnSignIn(){
        signInButton.click();
        return new CreateAccountPage(driver);
    }

}
*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@name=\"email\"]")
    private WebElement emailEditBox;
    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement passwordEditBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;
    @FindBy(xpath =  "//*[@id=\"root\"]/div/div/p/a")
    private WebElement signInButton;

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
    public HomePage clickButton(){
        loginButton.click();
        return new HomePage(driver);
    }
    public CreateAccountPage clickOnSignIn() {
        signInButton.click();
        return new CreateAccountPage(driver);
    }

}