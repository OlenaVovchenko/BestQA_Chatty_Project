package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {


    @FindBy(xpath = "//*[@class=\"form\"]")
    private WebElement contactForm;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContactFormIsDisplayed() {
        return contactForm.isDisplayed();
    }


}




