package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutChattyPage extends BasePage {
    public AboutChattyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='about-box']")
    private WebElement aboutChattyBox;


    public boolean isAboutChattyBoxIsDisplayed(String text) {
        return aboutChattyBox.getText().contains(text);
    }
}
