import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestContactUs extends BaseTest{
    @Test
    public void testContactUs() {
        LoginPage loginPage = new LoginPage(driver);
        ContactUsPage contactUsPage = loginPage.open()
                .enterEmail("olenagris@gmail.com")
                .enterPassword("chattytelran1")
                .clickButton()
                .clickOnContactUsButton()
                .fillNameInEditBoxInContact("s")
                .fillEmailInEditBoxInContact("olena@gmail.com")
                .fillContentInEditBoxInContact("Wtz")
                .clickOnButtonSendMessage();
        assertTrue(contactUsPage.isSuccessMessageDisplay(), "Success message is not displayed");
    }
}
