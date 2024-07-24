import baseTest.BaseTest;
import drivers.ChromeRegistry;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegistrationPage extends BaseTest {

    private final String userEmail = "945@web.de";
    private final String userPassword = "Oobubagabriel4465#";
    private final String userConfirmPassword = "Oobubagabriel4465#";

    @Test

    public void registrationNewUserWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignUp();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail(userEmail)
                .enterPassword(userPassword)
                .enterConfirmPassword(userConfirmPassword)
                .clickRegistrationButton();
        HomePage homePage = new HomePage(driver);

        assertTrue(homePage.isPostSectionDisplayed());


    }

    @Test
    public void registrationNewUserWithInvalidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignUp();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail(userEmail)
                .enterPassword(userPassword)
                .enterConfirmPassword(userConfirmPassword)
                .clickRegistrationButton();

        assertTrue(registrationPage.isErrorMessageDisplayed("Email already exists!"));

    }
}

