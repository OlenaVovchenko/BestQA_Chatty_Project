import org.junit.jupiter.api.Test;


public class TestContactUs extends BaseTest {
    private final String userEmail = "olenagris@gmail.com";
    private final String userPassword = "chattytelran1";
    private final String userName = "s";
    private final String content = "Wtz";

    @Test
    public void testSuccessMessageViaContactUs() {
        LoginPage loginPage = new LoginPage(driver);
        ContactUsPage contactUsPage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton()
                .clickOnContactUsButton()
                .fillNameInEditBoxInContact(userName)
                .fillEmailInEditBoxInContact(userEmail)
                .fillContentInEditBoxInContact(content)
                .clickOnButtonSendMessage();
        defineTestResultTrue(contactUsPage.isSuccessMessageDisplay());
    }

    @Test
    public void testUnsuccessfulMessageWithoutEmailContactUs() {
        LoginPage loginPage = new LoginPage(driver);
        ContactUsPage contactUsPage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton()
                .clickOnContactUsButton()
                .fillNameInEditBoxInContact(userName)
                .fillContentInEditBoxInContact(content)
                .clickOnButtonSendMessage();
        String emailValidationMessage = contactUsPage.getEmailValidationMessage();
        assertValidationMessage(emailValidationMessage, "Заполните это поле.");
    }
}
