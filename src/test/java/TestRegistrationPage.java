
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestRegistrationPage extends BaseTest {
    // private RegistrationPage registrationPage;



        @Test
        public void testUserValidRegistration() {
            ChromeDriver driver = new ChromeRegistry().registerDriver();
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = loginPage.open()
                    .enterEmail("olgale4@gmail.com")
                    .enterPassword("Oobubagabriel4465#")
                    .clickButton();

            assertTrue(homePage.isPostSectionDisplayed());

            driver.quit();
        }
    }


