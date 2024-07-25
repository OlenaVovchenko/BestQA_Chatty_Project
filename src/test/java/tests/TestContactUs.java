package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestContactUs extends BaseTest {
    private final String userEmail = "olenagris@gmail.com";
    private final String userPassword = "chattytelran1";
    private final String userName = "s";
    private final String content = "Wtz";

    @BeforeEach
    public void setUp() {
        super.setUp();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton();
    }

    @Test
    public void testSuccessMessageViaContactUs() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = homePage
                .clickOnContactUsButton()
                .fillNameInEditBoxInContact(userName)
                .fillEmailInEditBoxInContact(userEmail)
                .fillContentInEditBoxInContact(content)
                .clickOnButtonSendMessage();
        defineTestResultTrue(contactUsPage.isSuccessMessageDisplay());
    }

    @Test
    public void testUnsuccessfulMessageWithoutEmailContactUs() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = homePage
                .clickOnContactUsButton()
                .fillNameInEditBoxInContact(userName)
                .fillContentInEditBoxInContact(content)
                .clickOnButtonSendMessage();
        String emailValidationMessage = contactUsPage.getEmailValidationMessage();
        assertValidationMessage(emailValidationMessage, "Заполните это поле.");
    }
}
