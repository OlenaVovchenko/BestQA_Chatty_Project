import baseTest.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import drivers.ChromeRegistry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHomePage extends BaseTest {
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


    @Test
    public void checkAllPersonalPostsAreDisplayed() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle();
        homePage.allPersonalPostsAreDisplayed();

        driver.quit();
    }

    @Test
    public void checkPostsQuantity() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle();
        assertEquals(10, homePage.getPostsQuantity());

        driver.quit();
    }

    @Test
    public void checkPostCreation(){
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.open()
                .enterEmail("olgale4@gmail.com")
                .enterPassword("Oobubagabriel4465#")
                .clickButton();
        assertTrue(homePage.isPostSectionDisplayed());
        homePage.clickPostsToggle()
                .clickCreatePostPlusButton()
                .enterPostTitle("Hallo, it's a nice day today")
                .enterPostDescription("I'm totally ok today")
                .enterMyThoughts("Feeling great!")
                .attachImageToImageField("moneypic.jpeg")
                .clickPostButton();

                assertTrue(homePage.isPostTitlePresent());
        driver.quit();

    }

}


