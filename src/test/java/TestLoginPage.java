import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import drivers.ChromeRegistry;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginPage extends BaseTest {
    @Test
    public void testLoginWithValidData() {
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
