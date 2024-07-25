package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.DraftPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class TestSavingAsDraftPost extends BaseTest {
    private final String userEmail = "olenagris@gmail.com";
    private final String userPassword = "chattytelran1";
    private final String postTitle = "Test";
    private final String postDescription = "Hello";
    private final String postContent = "Hello";
    private final String postImage = "1321b5b0-44c1-4df0-8cfb-39cbbe8b06db.jpeg";

    @BeforeEach
    public void setUp() {
        super.setUp();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton();
    }
    @Test
    public void testSuccessfulSavingPostAsDraft() {
        HomePage homePage = new HomePage(driver);
        DraftPage draftPage = homePage
                .clickPostCreationButton()
                .fillInTitleEditBox(postTitle)
                .fillInDescriptionEditBox(postDescription)
                .fillInContentEditBox(postContent)
                .attachImageToImageField(postImage)
                .clickOnSaveAsDraftToggle()
                .clickOnSubmitPostButton()
                .clickOnMyDraftsButton();
        defineTestResultTrue(draftPage.isTextTitleInDraftPresent(postTitle));
    }

    @Test
    public void testUnsuccessfulSavingPostAsDraft() {
        HomePage homePage = new HomePage(driver);
        DraftPage draftPage = homePage
                .clickPostCreationButton()
                .fillInTitleEditBox("")
                .fillInDescriptionEditBox("Incomplete")
                .fillInContentEditBox("")
                .clickOnSaveAsDraftToggle()
                .clickOnSubmitPostButton()
                .clickOnMyDraftsButton();
        defineTestResultFalse(draftPage.isTextTitleInDraftPresent("Incomplete"));
    }
}
