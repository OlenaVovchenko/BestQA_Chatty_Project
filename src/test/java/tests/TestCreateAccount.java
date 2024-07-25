package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCreateAccount extends BaseTest {
    private final String userEmail = "erjkjrt3187@gmail.com";
    private final String userPassword = "Password234!";

    @Test
    public void successCreateUser() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .clickOnSignIn()
                .inputEmail(userEmail)
                .inputPassword(userPassword)
                .inputConfirmPassword(userPassword)
                .clickRegistrationButton();
        assertTrue(homePage.isTextHelloUserPresent("Hello, erjkjrt3187!"), "Massage is not present");
    }


    @Test
    public void testInvalidPasswordErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.open()
                .clickOnSignIn()
                .inputEmail("test@example.com")
                .inputPassword("s1s1s1")
                .inputConfirmPassword("s1s1s1");
        assertEquals("Password must be 8-100 characters and include at least one letter and one digit", "Password must be 8-100 characters and include at least one letter and one digit");
    }
}