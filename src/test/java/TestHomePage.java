import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHomePage {
    @Test
    public void checkPostElementIsDisplayed() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();

                assertTrue(homePage.isPostSectionDisplayed());

                homePage.clickPostsToggle();

                assertTrue(homePage.isPostPhotoDisplayed());
                assertTrue(homePage.isPostTitleDisplayed());
                assertTrue(homePage.isPostDescriptionDisplayed());


        driver.quit();
    }
}

