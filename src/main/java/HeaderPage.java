import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

    public class HeaderPage extends BasePage {

        public HeaderPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(xpath = "//*[@class='header-box']")
        private WebElement headerBox;

        @FindBy(xpath = "//*[@class='header__nav-list']")
        private WebElement navigationPanel;

        @FindBy(xpath = "//*[@class='header__user header__menu']")
        private WebElement headerUser;

        @FindBy(xpath = "//*[@href='/login']")
        private WebElement logoutLink;

        @FindBy(xpath = "//*[@href='/userprofile']")
        private WebElement yourProfileLink;

        @FindBy(xpath = "//*[@href='/draft']")
        private WebElement myDraftsLink;

        @FindBy(xpath = "//*[@href='/homeblog']")
        private WebElement homeLink;

        @FindBy(xpath = "//*[@href='/about']")
        private WebElement aboutLink;

        @FindBy(xpath = "//*[@href='/contact']")
        private WebElement contactLink;

        @FindBy(xpath = "//*[@alt='Logo']")
        private WebElement chattyLogo;

        public ContactUsPage clickOnContactLink() {
            contactLink.click();
            return new ContactUsPage(driver);
        }

        public HomePage clickOnHomeLink() {
            homeLink.click();
            return new HomePage(driver);
        }

        public LoginPage clickOnLogoutDropdown() {
            logoutLink.click();
            return new LoginPage(driver);
        }

        public DraftPage clickOnMyDraftsDropdown() {
            myDraftsLink.click();
            return new DraftPage(driver);
        }

        public PersonalInformationPage clickOnYourProfileDropdown() {
            yourProfileLink.click();
            return new PersonalInformationPage(driver);
        }

        public boolean isHeaderBoxIsDisplayed() {
            return headerBox.isDisplayed();
        }

        public boolean isHeaderNavigationPanelIsDisplayed() {
            return navigationPanel.isDisplayed();
        }

        public boolean isHeaderUserIsDisplayed() {
            return headerUser.isDisplayed();
        }

        public HeaderPage hoverDropdownMenu() {
            new Actions(driver).moveToElement(headerUser).perform();
            return this;
        }
    }

