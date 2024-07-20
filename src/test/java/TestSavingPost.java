import org.junit.jupiter.api.Test;


public class TestSavingPost extends BaseTest {
    private final String userEmail = "olenagris@gmail.com";
    private final String userPassword = "chattytelran1";
    private final String postTitle = "Test";
    private final String postDescription = "Hello";
    private final String postContent = "Hello";
    private final String postImage = "1321b5b0-44c1-4df0-8cfb-39cbbe8b06db.jpeg";

    @Test
    public void testSuccessfulSavingPostAsDraft() {
        LoginPage loginPage = new LoginPage(driver);
        DraftPage draftPage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton()
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
        LoginPage loginPage = new LoginPage(driver);
        DraftPage draftPage = loginPage.open()
                .enterEmail(userEmail)
                .enterPassword(userPassword)
                .clickButton()
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
