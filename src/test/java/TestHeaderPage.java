import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import pageObjects.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import drivers.ChromeRegistry;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestHeaderPage extends BaseTest {

    private final String userEmail = "olgale4@gmail.com";
    private final String userPassword = "Oobubagabriel4465#";

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
    public void checkHeaderElementsAreDisplayed() {
        HeaderPage headerPage= new HeaderPage(driver);
        assertTrue(headerPage.isHeaderBoxIsDisplayed());
        assertTrue(headerPage.isHeaderNavigationPanelIsDisplayed());
        assertTrue(headerPage.isHeaderUserIsDisplayed());

    }

    @Test
    public void checkHeaderAtAboutLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAboutLink();
        AboutChattyPage aboutChattyPage = new AboutChattyPage(driver);
        assertTrue(aboutChattyPage.isAboutChattyBoxIsDisplayed("Chatty"));
        HeaderPage headerPage = new HeaderPage(driver);
        assertTrue(headerPage.isHeaderBoxIsDisplayed());
        assertTrue(headerPage.isHeaderNavigationPanelIsDisplayed());
    }

    @Test
    public void checkHeaderAtContactLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnContactLink();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue(contactUsPage.isContactFormIsDisplayed());
        HeaderPage headerPage = new HeaderPage(driver);
        assertTrue(headerPage.isHeaderBoxIsDisplayed());
        assertTrue(headerPage.isHeaderNavigationPanelIsDisplayed());

    }

    @Test
    public void checkHeaderDropdownMenu() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverDropdownMenu();
        headerPage.clickOnMyDraftsDropdown();
        DraftPage draftPage = new DraftPage(driver);
        assertTrue(draftPage.isHereCanBeYourPostsTextPresent());
        headerPage.clickOnYourProfileDropdown();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());
        headerPage.clickOnLogoutDropdown();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isFormElementDisplayed());

    }
}