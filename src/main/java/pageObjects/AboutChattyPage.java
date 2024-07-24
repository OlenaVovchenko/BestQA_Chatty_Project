package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutChattyPage extends BasePage {

    @FindBy(xpath = "//*[@class='about-box']")
    private WebElement aboutChattyBox;

    public AboutChattyPage(WebDriver driver) {
        super(driver);
    }


    public boolean isAboutChattyBoxIsDisplayed(String text) {
        return aboutChattyBox.getText().contains(text);


    }


}

