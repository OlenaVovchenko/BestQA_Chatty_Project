import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PostPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import drivers.ChromeRegistry;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPostPage extends BaseTest {
    @Test
    public void checkPostIsDisplayed() {
         ChromeDriver driver = new ChromeRegistry().registerDriver();
         LoginPage loginPage = new LoginPage(driver);
         HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();

        assertTrue(homePage.isPostSectionDisplayed());

        homePage.clickPostsToggle();
        PostPage postPage= new PostPage(driver);
        homePage.clickPost();

        assertTrue(postPage.isPostTitleDisplayed());
        assertTrue(postPage.isPostDescriptionDisplayed());
        assertTrue(postPage.isPostPhotoDisplayed());
    }

}









