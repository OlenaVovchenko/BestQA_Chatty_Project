package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCreateAccount extends BaseTest {


    @Test
    public void successCreateUser() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .clickOnSignIn()
                .inputEmail("erjkjrt3987@gmail.com")
                .inputPassword("Password234!")
                .inputConfirmPassword("Password234!")
                .clickRegistrationButton();
        assertTrue(homePage.isTextHelloUserPresent("Hello, erjkjrt3987!"), "Massage is not present");
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