package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginPage extends BaseTest {
    @Test
    public void testLoginWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olenagris@gmail.com")
                .enterPassword("chattytelran1")
                .clickButton();
        assert (homePage.isPostSectionDisplayed());
    }
    @Test
    public void testLoginWithInvalidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .enterEmail("invalidemail")
                .enterPassword("chattytelran1")
                .clickButton();
        assertTrue(loginPage.isEmailErrorMessageDisplayed(), "Incorrect email");
    }
}
