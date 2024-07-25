import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonalInformationPage extends BaseTest {

    private final String userEmail = "georgetavarvarici@gmail.com";
    private final String userPassword = "gigivarvarici1992";
    private final String userName = "georgeta";
    private final String userSurname = "varvarici";
    private final String userGender = "female";
    private final String userPhone = "1234567";
    private final String oldPassword = "gigivarvarici1992";
    private final String newPassword = "NewPassword4465#";
    private final String confirmPassword = "NewPassword4465";
    private final String birthDate = "15";
    private final String birthMonth = "September";
    private final String birthYear = "1991";

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