import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalInformationPage extends BasePage {
    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='post-header__plus-box']")
    private WebElement plusBox;

    @FindBy(xpath = "//*[@class='sidebar__section']")
    private WebElement sidebarSection;


    @FindBy(xpath = "//*[@class='suggestions__section']")
    private WebElement suggestionSection;

    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement headerPlus;


    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name='surname']")
    private WebElement inputSurname;

    @FindBy(id = "gender")
    private WebElement genderSelect;

    @FindBy(id = "birthDate")
    private WebElement inputBirthdate;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement inputPhone;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement changePasswordButton;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;


    public boolean isPostHeaderIsDisplayed() {
        return plusBox.isDisplayed();

    }

    public PersonalInformationPage clickOnPlusBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(headerPlus)).click();
        headerPlus.click();
        return this;

    }


    public PersonalInformationPage enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(name);
        return this;
    }


    public PersonalInformationPage enterSurname(String surname) {
        inputSurname.sendKeys(surname);
        return this;
    }

    public PersonalInformationPage selectGender(String gender) {
        genderSelect.click();
        genderSelect.sendKeys(gender);
        return this;
    }

    public PersonalInformationPage fillInBirthdate(String date, String month, String year) {
        inputBirthdate.clear();
        inputBirthdate.sendKeys(date + month + year);
        return this;
    }


    public PersonalInformationPage enterPhone(String phone) {
        inputPhone.clear();
        inputPhone.sendKeys(phone);
        return this;
    }

    public PersonalInformationPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public PersonalInformationPasswordPage clickChangePasswordButton() {
        changePasswordButton.click();
        return new PersonalInformationPasswordPage(driver);
    }
}