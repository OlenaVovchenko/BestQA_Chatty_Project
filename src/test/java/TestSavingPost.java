import org.junit.jupiter.api.Test;

public class TestSavingPost extends BaseTest{


    @Test
    public void testSavingPostAsDraft() {
        LoginPage loginPage = new LoginPage(driver);
        DraftPage draftPage = loginPage.open()
                .enterEmail("olenagris@gmail.com")
                .enterPassword("chattytelran1")
                .clickButton()
                .clickPostCreationButton()
                .fillInTitleEditBox("Test")
                .fillInDescriptionEditBox("Hello")
                .fillInContentEditBox("Hello")
                .attachImageToImageField("1321b5b0-44c1-4df0-8cfb-39cbbe8b06db.jpeg")
                .clickOnSaveAsDraftToggle()
                .clickOnSubmitPostButton()
                .clickOnMyDraftsButton();
        defineTestResultTrue(draftPage.isTextTitleInDraftPresent("Test"));
    }
}
