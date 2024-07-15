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

    @Test

    public void registrationNewUserWithValidData() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
                loginPage.open()
                .clickSignUp();

        RegistrationPage registrationPage= new RegistrationPage(driver);
        registrationPage.enterEmail("223@web.de")
                        .enterPassword("Oobubagabriel4465#")
                        .enterConfirmPassword("Oobubagabriel4465#")
                        .clickRegistrationButton();
        HomePage homePage= new HomePage(driver);

        assertTrue(homePage.isPostSectionDisplayed());

        driver.quit();


    }
     @Test
    public void registrationNewUserWithInvalidData() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignUp();

        RegistrationPage registrationPage= new RegistrationPage(driver);
        registrationPage.enterEmail("olgaya@web.de")
                .enterPassword("Oobubagabriel4465#")
                .enterConfirmPassword("Oobubagabriel4465#")
                .clickRegistrationButton();

        assertTrue(registrationPage.isErrorMessageDisplayed("Email already exists!"));

        driver.quit();


    }
}

