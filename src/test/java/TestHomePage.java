import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import drivers.ChromeRegistry;

import static org.junit.jupiter.api.Assertions.*;

public class TestHomePage extends BaseTest {

    private final String userEmail = "olgale4@gmail.com";
    private final String userPassword = "Oobubagabriel4465#";
    private final String postTitle = "Hallo, it's a nice day today";
    private final String postDescription = "I'm totally ok today";
    private final String myThoughts = "Feeling great!";
    private final String postImage = "moneypic.jpeg";

    @BeforeEach
    public void setUp() {
        super.setUp();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());

    }

    @Test
    public void checkPostElementIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle();
        assertTrue(homePage.isPostPhotoDisplayed());
        assertTrue(homePage.isPostTitleDisplayed());
        assertTrue(homePage.isPostDescriptionDisplayed());
    }


    @Test
    public void checkAllPersonalPostsAreDisplayed() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle();
        assertTrue(homePage.allPersonalPostsAreDisplayed());

    }

    @Test
    public void checkPostsQuantity() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle();
        assertNotEquals(10, homePage.getPostsQuantity());
    }

    @Test
    public void checkPostCreation() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle()
                .clickCreatePostPlusButton()
                .enterPostTitle(postTitle)
                .enterPostDescription(postDescription)
                .enterMyThoughts(myThoughts)
                .attachImageToImageField(postImage)
                .clickPostButton();

        assertTrue(homePage.isPostTitlePresent());


    }

}


