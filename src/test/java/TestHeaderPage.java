import baseTest.BaseTest;
import pageObjects.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import drivers.ChromeRegistry;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHeaderPage extends BaseTest {
    @Test
    public void checkHeaderElementsAreDisplayed() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.isHeaderBoxIsDisplayed();
        headerPage.isHeaderNavigationPanelIsDisplayed();
        headerPage.isHeaderUserIsDisplayed();
               driver.quit();
    }

    @Test
    public void checkHeaderAtAboutLink() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());

        homePage.clickOnAboutLink();
        AboutChattyPage aboutChattyPage = new AboutChattyPage(driver);
        assertTrue(aboutChattyPage.isAboutChattyBoxIsDisplayed("Chatty"));
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.isHeaderBoxIsDisplayed();
        headerPage.isHeaderNavigationPanelIsDisplayed();
              driver.quit();
    }

    @Test
    public void checkHeaderAtContactLink() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.clickOnContactLink();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue(contactUsPage.isContactFormIsDisplayed());

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.isHeaderBoxIsDisplayed();
        headerPage.isHeaderNavigationPanelIsDisplayed();

        driver.quit();
    }

    @Test
    public void checkHeaderDropdownMenu() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();

        assertTrue(homePage.isPostSectionDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage.hoverDropdownMenu();

        headerPage.clickOnMyDraftsDropdown();
        DraftPage draftPage = new DraftPage(driver);
        assertTrue(draftPage.isHereCanBeYourPostsTextPresent());

        headerPage.clickOnYourProfileDropdown();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        assertTrue(personalInformationPage.isPostHeaderIsDisplayed());


        headerPage.clickOnLogoutDropdown();
        assertTrue(loginPage.isFormElementDisplayed());

}
}