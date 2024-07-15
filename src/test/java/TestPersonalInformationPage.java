import baseTest.BaseTest;
import pageObjects.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonalInformationPage extends BaseTest {

    @Test
    public void fillingInPersonalInformationForm() {
        ChromeDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();

        assertTrue(homePage.isPostSectionDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverDropdownMenu().clickOnYourProfileDropdown();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());
        driver.manage().window().maximize();

        personalInformationPage.clickOnPlusBox()
                .enterName("Olga")
                .enterSurname("Zeltser")
                .selectGender("female")
                .fillInBirthdate("1", "June", "1981")
                .enterPhone("1234567")
                .clickSaveButton();

        personalInformationPage.clickSaveButton();

        driver.quit();

    }

    @Test
    public void fillingInChangePasswordField() {
        ChromeDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();

        assertTrue(homePage.isPostSectionDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage.hoverDropdownMenu().clickOnYourProfileDropdown();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);

        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());
        driver.manage().window().maximize();
        personalInformationPage.clickChangePasswordButton();

        PersonalInformationPasswordPage passwordPage = new PersonalInformationPasswordPage(driver);
        assertTrue(passwordPage.isPasswordBoxDisplayed());

        passwordPage.inputOldPassword("OldPassword123")
                .inputNewPassword("NewPassword4465#")
                .confirmNewPassword("NewPassword4465#")
                .clickSaveButton();


        driver.quit();

    }
}









