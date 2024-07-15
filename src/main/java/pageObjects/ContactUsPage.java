package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"form\"]")
    private WebElement contactForm;


    public boolean isContactFormIsDisplayed() {
        return contactForm.isDisplayed();
    }



}




