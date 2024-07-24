package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalInformationPage extends BasePage {
    private WebDriverWait wait;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
        wait.until(ExpectedConditions.elementToBeClickable(headerPlus)).click();
        headerPlus.click();
        return this;

    }


    public PersonalInformationPage enterName(String name) {
        wait.until(ExpectedConditions.visibilityOf(inputName));

        if (inputName.isDisplayed() && inputName.isEnabled()) {
            inputName.sendKeys(name);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputName);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + name + "';", inputName);
        }

        return this;
    }

    public PersonalInformationPage enterSurname(String surname) {
          wait.until(ExpectedConditions.visibilityOf(inputSurname));

        if (inputSurname.isDisplayed() && inputSurname.isEnabled()) {
            inputSurname.sendKeys(surname);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputSurname);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + surname + "';", inputSurname);
        }

        return this;
    }


    public PersonalInformationPage selectGender(String gender) {
          wait.until(ExpectedConditions.visibilityOf(genderSelect));

        if (genderSelect.isDisplayed() && genderSelect.isEnabled()) {
            genderSelect.click();
            genderSelect.sendKeys(gender);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderSelect);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderSelect);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + gender + "';", genderSelect);
        }

        return this;
    }


    public PersonalInformationPage fillInBirthdate(String date, String month, String year) {
        wait.until(ExpectedConditions.visibilityOf(inputBirthdate));
        String birthdate = date + month + year;

        if (inputBirthdate.isDisplayed() && inputBirthdate.isEnabled()) {
            inputBirthdate.clear();
            inputBirthdate.sendKeys(birthdate);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputBirthdate);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", inputBirthdate);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + birthdate + "';", inputBirthdate);
        }

        return this;
    }



    public PersonalInformationPage enterPhone(String phone) {
         wait.until(ExpectedConditions.visibilityOf(inputPhone));

        if (inputPhone.isDisplayed() && inputPhone.isEnabled()) {
            inputPhone.clear();
            inputPhone.sendKeys(phone);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputPhone);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", inputPhone);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + phone + "';", inputPhone);
        }

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




