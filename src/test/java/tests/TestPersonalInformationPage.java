package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonalInformationPage extends BaseTest {

    private final String userEmail = "olgale4@gmail.com";
    private final String userPassword = "Oobubagabriel4465#";
    private final String userName = "olga";
    private final String userSurname = "zeltser";
    private final String userGender = "female";
    private final String userPhone = "1234567";
    private final String oldPassword = "OldPassword123";
    private final String newPassword = "NewPassword4465#";
    private final String confirmPassword = "NewPassword4465";
    private final String birthDate = "01";
    private final String birthMonth = "June";
    private final String birthYear = "1981";

    @BeforeEach
    public void setUp() {
        super.setUp();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());
    }

    @Test
    public void fillingInPersonalInformationForm() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverDropdownMenu().clickOnYourProfileDropdown();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());
        personalInformationPage.clickOnPlusBox()
                .enterName(userName)
                .enterSurname(userSurname)
                .selectGender(userGender)
                .fillInBirthdate(birthDate, birthMonth, birthYear)
                .enterPhone(userPhone)
                .clickSaveButton();
    }

    @Test
    public void fillingInChangePasswordField() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPostSectionDisplayed());
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverDropdownMenu().clickOnYourProfileDropdown();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());
        personalInformationPage.clickChangePasswordButton();
        PersonalInformationPasswordPage passwordPage = new PersonalInformationPasswordPage(driver);
        assertTrue(passwordPage.isPasswordBoxDisplayed());

        passwordPage.inputOldPassword(oldPassword)
                .inputNewPassword(newPassword)
                .confirmNewPassword(confirmPassword)
                .clickSaveButton();

    }

    @Test
    public void fillingInChangePasswordFieldWithPasswordsNotMatching() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPostSectionDisplayed());
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverDropdownMenu().clickOnYourProfileDropdown();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());
        personalInformationPage.clickChangePasswordButton();
        PersonalInformationPasswordPage passwordPage = new PersonalInformationPasswordPage(driver);
        assertTrue(passwordPage.isPasswordBoxDisplayed());

        passwordPage.inputOldPassword(oldPassword)
                .inputNewPassword(newPassword)
                .confirmNewPassword(confirmPassword)
                .clickSaveButton();

        passwordPage.isErrorMessageDisplayed("The new passwords do not match.");
    }
}