import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPage extends BaseTest{
    @Test
    public void testLoginWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olenagris@gmail.com")
                .enterPassword("chattytelran1")
                .clickButton();
        assert(homePage.isPostSectionDisplayed());
       }
}
