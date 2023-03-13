package PageObjects;

import Utils.HelperMethods;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Slf4j
public class TravellersHomePage extends HelperMethods {
    private final WebDriver driver;
    @FindBy(xpath = "(//span[@class='select2-chosen'])[1]")
    private WebElement searchClick;
    @FindBy(css = "div[id='select2-drop'] input[type='text']")
    private WebElement searchInput;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
    private WebElement searchChooseFromList;
    @FindBy(css = "input[name='checkin']")
    private WebElement checkInInput;
    @FindBy(css = "input[name='checkout']")
    private WebElement checkOutInput;

    @FindBy(css = "#travellersInput")
    private WebElement guestNumberField;

    @FindBy(css = "#adultPlusBtn")
    private WebElement adultPlusBtn;
    @FindBy(css = "#childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Search'])[1]")
    private WebElement searchingBtn;
    @FindBy(xpath = "(//li[@id='li_myaccount'])[2]")
    private WebElement myAccountBtn;
    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]")
    private WebElement myAccountDropdownMenu;

    public TravellersHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public TravellersHomePage searchCity(String city) {
        log.debug("Setting city: " + city);
        searchClick.click();
        inputSendKeysHelper(searchInput, city);
        searchChooseFromList.click();
        log.debug("Finished Setting city");
        return this;
    }

    public TravellersHomePage enterCheckDates(String checkIn, String checkOut) {
        log.debug("Setting dates: Check-in: " + checkIn + ", " + "Check-out: " + checkOut);
        inputSendKeysHelper(checkInInput, checkIn);
        inputSendKeysHelper(checkOutInput, checkOut);
        log.debug("Finished setting dates.");
        return this;
    }

    public TravellersHomePage enterGuestNumber(int adultsNumber, int kidsNumber) {
        log.debug("Setting adults number: " + adultsNumber + ", kids number: " + kidsNumber);
        guestNumberField.click();
        forLoopAddingGuest(adultPlusBtn, 2, adultsNumber);
        forLoopAddingGuest(childPlusBtn, 0, kidsNumber);
        log.debug("Finished settings guest numbers");
        return this;
    }

    public HotelResultPage searchButtonClick() {
        searchingBtn.click();
        return new HotelResultPage(driver);
    }

    public SignUpPage signUpClick() {
        myAccountBtn.click();
        getMatcherElementFromList(myAccountDropdownMenu, "Sign Up").click();
        return new SignUpPage(driver);
    }

    public LoginPage LoginClick() {
        myAccountBtn.click();
        getMatcherElementFromList(myAccountDropdownMenu, "Login").click();
        return new LoginPage(driver);
    }
}
