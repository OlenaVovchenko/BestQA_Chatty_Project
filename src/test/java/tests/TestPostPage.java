package tests;

import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PostPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPostPage extends BaseTest {
    private final String userEmail = "olgale4@gmail.com";
    private final String userPassword = "Oobubagabriel4465#";

    @Test
    public void checkPostIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton();

        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle();
        PostPage postPage = new PostPage(driver);
        homePage.clickPost();
        assertTrue(postPage.isPostTitleDisplayed());
        assertTrue(postPage.isPostDescriptionDisplayed());
        assertTrue(postPage.isPostPhotoDisplayed());
    }

}
